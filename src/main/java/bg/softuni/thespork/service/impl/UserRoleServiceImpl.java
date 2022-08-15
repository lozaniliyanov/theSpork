package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.UserRoleEntity;
import bg.softuni.thespork.model.entities.enums.UserRole;
import bg.softuni.thespork.repository.UserRoleRepository;
import bg.softuni.thespork.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void seedRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);
            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}
