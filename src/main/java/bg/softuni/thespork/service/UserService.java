package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.service.UserServiceModel;

public interface UserService {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    UserEntity findById(Long id);

    UserEntity findByName(String username);

    UserServiceModel findUserByUsername(String username);

    UserServiceModel findByUsername(String username);

    void registerAndLoginUser(UserServiceModel userServiceModel);

    void seedUsers();

    void updateProfile(UserServiceModel userServiceModel, String username, String newUsername);

    UserServiceModel changePassword(UserServiceModel userServiceModel, String oldPassword, String username);
}
