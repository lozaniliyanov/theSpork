package bg.softuni.thespork.model.service;

import java.util.List;

public class MenuServiceModel {
    private RestaurantServiceModel restaurantServiceModel;
    private List<MenuServiceModel> menuItems;

    public MenuServiceModel() {

    }

    public RestaurantServiceModel getRestaurantServiceModel() {
        return restaurantServiceModel;
    }

    public MenuServiceModel setRestaurantServiceModel(RestaurantServiceModel restaurantServiceModel) {
        this.restaurantServiceModel = restaurantServiceModel;
        return this;
    }

    public List<MenuServiceModel> getMenuItems() {
        return menuItems;
    }

    public MenuServiceModel setMenuItems(List<MenuServiceModel> menuItems) {
        this.menuItems = menuItems;
        return this;
    }
}
