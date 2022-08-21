package bg.softuni.thespork.model.view;

import java.util.List;

public class MenuViewModel {

    private RestaurantViewModel restaurant;
    private List<MenuItemViewModel> menuItems;

    public MenuViewModel() {

    }

    public RestaurantViewModel getRestaurant() {
        return restaurant;
    }

    public MenuViewModel setRestaurant(RestaurantViewModel restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<MenuItemViewModel> getMenuItems() {
        return menuItems;
    }

    public MenuViewModel setMenuItems(List<MenuItemViewModel> menuItems) {
        this.menuItems = menuItems;
        return this;
    }
}
