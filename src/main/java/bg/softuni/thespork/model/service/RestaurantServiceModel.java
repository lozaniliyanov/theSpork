package bg.softuni.thespork.model.service;

import java.util.List;

public class RestaurantServiceModel {
    private UserServiceModel owner;
    private RestaurantServiceModel restaurant;
    private String cuisine;
    private String priceRange;
    private List<ReviewServiceModel> reviews;

    public RestaurantServiceModel() {

    }

    public UserServiceModel getOwner() {
        return owner;
    }

    public RestaurantServiceModel setOwner(UserServiceModel owner) {
        this.owner = owner;
        return this;
    }

    public RestaurantServiceModel getRestaurant() {
        return restaurant;
    }

    public RestaurantServiceModel setRestaurant(RestaurantServiceModel restaurant) {
        this.restaurant = restaurant;
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

    public List<ReviewServiceModel> getReviews() {
        return reviews;
    }

    public RestaurantServiceModel setReviews(List<ReviewServiceModel> reviews) {
        this.reviews = reviews;
        return this;
    }
}
