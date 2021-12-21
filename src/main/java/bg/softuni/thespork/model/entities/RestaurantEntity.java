package bg.softuni.thespork.model.entities;

import bg.softuni.thespork.model.entities.enums.Cuisine;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity extends BaseEntity {
    @OneToOne
    private UserEntity owner;
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    public RestaurantEntity() {

    }

    public UserEntity getOwner() {
        return owner;
    }

    public RestaurantEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
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
}
