package bg.softuni.thespork.init;

import bg.softuni.thespork.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TheSporkApplicationInit implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final MenuService menuService;
    private final MenuItemService menuItemService;

    public TheSporkApplicationInit(UserRoleService userRoleService, UserService userService, RestaurantService restaurantService, ReviewService reviewService, MenuService menuService, MenuItemService menuItemService) {

        this.userRoleService = userRoleService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.reviewService = reviewService;
        this.menuService = menuService;
        this.menuItemService = menuItemService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.seedRoles();
        userService.seedUsers();
//        restaurantService.seedRestaurants();
        // TODO: 20/08/2022 remove seeds
//        reviewService.seedReviews();
//        menuService.seedMenus();
//        menuItemService.seedMenuItems();

    }
}