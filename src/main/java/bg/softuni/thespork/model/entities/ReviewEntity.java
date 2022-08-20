package bg.softuni.thespork.model.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class ReviewEntity extends BaseEntity {
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;
    @Column(name = "rating", nullable = false)
    private double rating;
    @Column(name = "price_range")
    private String priceRange;
    @Column(name = "created_date", nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();
    @ManyToOne
    private RestaurantEntity restaurant;
    @ManyToOne
    private UserEntity author;

    public ReviewEntity() {

    }

    public String getComment() {
        return comment;
    }

    public ReviewEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public ReviewEntity setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public ReviewEntity setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public ReviewEntity setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public ReviewEntity setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public ReviewEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
