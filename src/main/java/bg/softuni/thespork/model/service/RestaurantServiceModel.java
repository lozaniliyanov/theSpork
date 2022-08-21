package bg.softuni.thespork.model.service;

import java.util.List;

public class RestaurantServiceModel {
    private String owner;
    private String restaurantName;
    private String cuisine;
    private String priceRange;
    private MenuServiceModel menuServiceModel;
    private List<ReviewServiceModel> reviews;

    public RestaurantServiceModel() {

    }

    public String getOwner() {
        return owner;
    }

    public RestaurantServiceModel setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantServiceModel setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public String getCuisine() {
        return cuisine;
    }

    public RestaurantServiceModel setCuisine(String cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public RestaurantServiceModel setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public MenuServiceModel getMenuServiceModel() {
        return menuServiceModel;
    }

    public RestaurantServiceModel setMenuServiceModel(MenuServiceModel menuServiceModel) {
        this.menuServiceModel = menuServiceModel;
        return this;
    }

    public List<ReviewServiceModel> getReviews() {
        return reviews;
    }

    public RestaurantServiceModel setReviews(List<ReviewServiceModel> reviews) {
        this.reviews = reviews;
        return this;
    }
}
