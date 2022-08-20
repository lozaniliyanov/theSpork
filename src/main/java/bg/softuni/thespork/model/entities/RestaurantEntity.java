package bg.softuni.thespork.model.entities;

import bg.softuni.thespork.model.entities.enums.Cuisine;
import bg.softuni.thespork.model.entities.enums.PriceRange;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity extends BaseEntity {
    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;
    @OneToOne
    private MenuEntity menuEntity;
    @Column(name = "rating")
    private double rating;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity owner;
    @OneToMany(mappedBy = "restaurant")
    private List<ReviewEntity> reviews;

    public RestaurantEntity() {

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantEntity setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public RestaurantEntity setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public RestaurantEntity setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public MenuEntity getMenuEntity() {
        return menuEntity;
    }

    public RestaurantEntity setMenuEntity(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public RestaurantEntity setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public RestaurantEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public RestaurantEntity setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
        return this;
    }
}
