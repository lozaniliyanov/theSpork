package bg.softuni.thespork.model.view;

import bg.softuni.thespork.model.entities.enums.Cuisine;
import bg.softuni.thespork.model.entities.enums.PriceRange;

import java.util.List;

public class RestaurantViewModel {
    private String restaurantName;
    private Cuisine cuisine;
    private PriceRange priceRange;
    private double rating;
    private UserViewModel owner;
    private MenuViewModel menu;
    private List<ReviewViewModel> reviews;

    public RestaurantViewModel() {

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantViewModel setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public RestaurantViewModel setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public RestaurantViewModel setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public RestaurantViewModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public UserViewModel getOwner() {
        return owner;
    }

    public RestaurantViewModel setOwner(UserViewModel owner) {
        this.owner = owner;
        return this;
    }

    public MenuViewModel getMenu() {
        return menu;
    }

    public RestaurantViewModel setMenu(MenuViewModel menu) {
        this.menu = menu;
        return this;
    }

    public List<ReviewViewModel> getReviews() {
        return reviews;
    }

    public RestaurantViewModel setReviews(List<ReviewViewModel> reviews) {
        this.reviews = reviews;
        return this;
    }
}