package bg.softuni.thespork.model.service;

public class RestaurantAddServiceModel {
    private String owner;
    private String restaurantName;
    private String cuisine;
    private String priceRange;

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

    public String getCuisine() {
        return cuisine;
    }

    public RestaurantAddServiceModel setCuisine(String cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public RestaurantAddServiceModel setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        return this;
    }

}
