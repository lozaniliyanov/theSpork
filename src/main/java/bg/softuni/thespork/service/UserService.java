package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.service.UserRegistrationServiceModel;

public interface UserService {

    boolean userNameExists(String username);
    UserEntity findByName(String username);
    UserEntity findById(Long id);
    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    void seedAdmin();
}
