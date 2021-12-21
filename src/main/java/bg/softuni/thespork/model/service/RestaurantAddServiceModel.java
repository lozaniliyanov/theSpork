package bg.softuni.thespork.model.service;

import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.entities.enums.Cuisine;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

public class RestaurantAddServiceModel {
    private String owner;
    private String restaurantName;
    private Cuisine cuisine;

    public RestaurantAddServiceModel() {

    }

    public String getOwner() {
        return owner;
    }

    public RestaurantAddServiceModel setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantAddServiceModel setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public RestaurantAddServiceModel setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }
}
