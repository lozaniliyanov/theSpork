package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.exceptions.UserWithUsernameNotFoundException;
import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.entities.UserRoleEntity;
import bg.softuni.thespork.model.entities.enums.Title;
import bg.softuni.thespork.model.entities.enums.UserRole;
import bg.softuni.thespork.model.service.UserServiceModel;
import bg.softuni.thespork.repository.UserRepository;
import bg.softuni.thespork.repository.UserRoleRepository;
import bg.softuni.thespork.service.CloudinaryService;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final TheSporkUserService theSporkUserService;
    private final CloudinaryService cloudinaryService;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           TheSporkUserService theSporkUserService, CloudinaryService cloudinaryService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.theSporkUserService = theSporkUserService;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        UserEntity user = this.userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserWithUsernameNotFoundException(String.format("User with this username does not exist!: %s", username)));

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UserWithUsernameNotFoundException(String.format("User with username %s not found", username)));
        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public void registerAndLoginUser(UserServiceModel userServiceModel) {
        UserEntity newUser = modelMapper.map(userServiceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER).orElseThrow(() -> new IllegalStateException("USER role not found. Please seed the roles."));
        newUser.addRole(userRole);
        newUser = userRepository.save(newUser);
        UserDetails principal = theSporkUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal, newUser.getPassword(), principal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity().setUsername("admin").setPassword(passwordEncoder.encode("1234")).setEmail("admin@softuni.bg").setFirstName("Lozan").setLastName("Lozanov").setTitle(Title.Mr);
            UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER).
                    orElseThrow(() -> new IllegalStateException("USER role not found. Please seed the roles."));
            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRole.ADMIN).
                    orElseThrow(() -> new IllegalStateException("ADMIN role not found. Please seed the roles."));
            admin.addRole(userRole);
            admin.addRole(adminRole);
            userRepository.saveAndFlush(admin);
            UserEntity pikosOwner = new UserEntity().setUsername("pikosOwner").setPassword(passwordEncoder.encode("1234")).setEmail("pikosOwner@softuni.bg").setFirstName("Lozan").setLastName("Lozanov").setTitle(Title.Mr);
            pikosOwner.addRole(userRole);
            userRepository.save(pikosOwner);
            UserEntity mamosOwner = new UserEntity().setUsername("mamosOwner").setPassword(passwordEncoder.encode("1234")).setEmail("mamosOwner@softuni.bg").setFirstName("Lozan").setLastName("Lozanov").setTitle(Title.Mr);
            mamosOwner.addRole(userRole);
            userRepository.save(mamosOwner);
        }
    }

    @Override
    public void updateProfile(UserServiceModel userServiceModel, String username, String newUsername) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UserWithUsernameNotFoundException(String.format("User with NOT FOUND  username: %s", username)));
        user.
                setUsername(newUsername).
                setFirstName(userServiceModel.getFirstName()).
                setLastName(userServiceModel.getLastName()).
                setTitle(userServiceModel.getTitle()).
                setEmail(userServiceModel.getEmail()).
                setProfilePic(userServiceModel.getProfilePic());
        userRepository.saveAndFlush(user);
        modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel changePassword(UserServiceModel userServiceModel, String newPassword, String username) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Username not found %s", userServiceModel.getUsername())));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.saveAndFlush(user);
        return modelMapper.map(user, UserServiceModel.class);
    }
}

