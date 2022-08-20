package bg.softuni.thespork.model.service;

import java.time.LocalDateTime;

public class ReviewServiceModel {
    private UserServiceModel user;
    private String comment;
    private double rating;
    private LocalDateTime postedTime = LocalDateTime.now();
    private RestaurantServiceModel restaurant;

    public ReviewServiceModel() {

    }

    public UserServiceModel getUser() {
        return user;
    }

    public ReviewServiceModel setUser(UserServiceModel user) {
        this.user = user;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ReviewServiceModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public ReviewServiceModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public ReviewServiceModel setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
        return this;
    }

    public RestaurantServiceModel getRestaurant() {
        return restaurant;
    }

    public ReviewServiceModel setRestaurant(RestaurantServiceModel restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
