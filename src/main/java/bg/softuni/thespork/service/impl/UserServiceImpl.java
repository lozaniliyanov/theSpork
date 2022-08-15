package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.entities.UserRoleEntity;
import bg.softuni.thespork.model.entities.enums.UserRole;
import bg.softuni.thespork.model.service.UserRegistrationServiceModel;
import bg.softuni.thespork.model.view.UserViewModel;
import bg.softuni.thespork.repository.UserRepository;
import bg.softuni.thespork.repository.UserRoleRepository;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final TheSporkUserService theSporkUserService;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           TheSporkUserService theSporkUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.theSporkUserService = theSporkUserService;


    }


    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
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
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {
        UserEntity newUser = modelMapper.map(userRegistrationServiceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER).
                orElseThrow(() -> new IllegalStateException("USER role not found. Please seed the roles."));
        newUser.addRole(userRole);
        newUser = userRepository.save(newUser);
        UserDetails principal = theSporkUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal, newUser.getPassword(), principal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void seedAdmin() {
        UserEntity admin = new UserEntity().setUsername("admin").setPassword(passwordEncoder.encode("1234")).setEmail("admin@softuni.bg").setFirstName("Lozan").setSurname("Lozanov");
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER).
                orElseThrow(() -> new IllegalStateException("USER role not found. Please seed the roles."));
        UserRoleEntity adminRole = userRoleRepository.findByRole(UserRole.ADMIN).
                orElseThrow(() -> new IllegalStateException("ADMIN role not found. Please seed the roles."));
        admin.addRole(userRole);
        admin.addRole(adminRole);
        userRepository.save(admin);
    }

    @Override
    public UserViewModel findByUsername(String username) {
        return modelMapper.map(userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new), UserViewModel.class);
    }
}

