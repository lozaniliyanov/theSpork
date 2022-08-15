package bg.softuni.thespork.model.entities;

import bg.softuni.thespork.model.entities.enums.Cuisine;
import bg.softuni.thespork.model.entities.enums.PriceRange;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity extends BaseEntity {
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

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
}
