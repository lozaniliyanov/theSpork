package bg.softuni.thespork.model.binding;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.entities.enums.Cuisine;

public class RestaurantAddBindingModel {
    private String owner;
    private String restaurantName;
    private Cuisine cuisine;

    public RestaurantAddBindingModel() {

    }

    public String getOwner() {
        return owner;
    }

    public RestaurantAddBindingModel setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantAddBindingModel setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public RestaurantAddBindingModel setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }
}
