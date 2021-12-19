package bg.softuni.thespork.init;

import bg.softuni.thespork.service.UserRoleService;
import bg.softuni.thespork.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TheSporkApplicationInit implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final UserService userService;

    public TheSporkApplicationInit(UserRoleService userRoleService, UserService userService) {

        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.seedRoles();
        userService.seedAdmin();
    }
}
