package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.service.UserRegistrationServiceModel;
import bg.softuni.thespork.model.view.UserViewModel;

public interface UserService {

    boolean userNameExists(String username);

    boolean emailExists(String email);

    UserEntity findById(Long id);

    UserEntity findByName(String username);

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    void seedAdmin();

    UserViewModel findByUsername(String username);
//    UserViewModel findByUsername(String username);
}
