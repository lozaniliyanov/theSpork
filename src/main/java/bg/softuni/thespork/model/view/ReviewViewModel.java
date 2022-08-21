package bg.softuni.thespork.model.view;

import java.time.LocalDateTime;

public class ReviewViewModel {
    private String comment;
    private double rating;
    private String priceRange;
    private LocalDateTime createdDate;
    private RestaurantViewModel restaurant;
    private UserViewModel author;

    public ReviewViewModel() {

    }

    public String getComment() {
        return comment;
    }

    public ReviewViewModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public ReviewViewModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public ReviewViewModel setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public ReviewViewModel setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RestaurantViewModel getRestaurant() {
        return restaurant;
    }

    public ReviewViewModel setRestaurant(RestaurantViewModel restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public UserViewModel getAuthor() {
        return author;
    }

    public ReviewViewModel setAuthor(UserViewModel author) {
        this.author = author;
        return this;
    }
}
