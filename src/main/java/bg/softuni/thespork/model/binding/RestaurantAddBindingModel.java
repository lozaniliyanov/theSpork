package bg.softuni.thespork.model.binding;

import bg.softuni.thespork.model.entities.enums.Cuisine;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantAddBindingModel {
    @NotBlank(message = "This field is required")
    @Length(min = 2, max = 20, message = "Restaurant name must between 2 and 20 characters long")
    private String restaurantName;
    @NotNull(message = "Please specify the cuisine")
    private Cuisine cuisine;

    public RestaurantAddBindingModel() {

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantAddBindingModel setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public RestaurantAddBindingModel setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }
}
