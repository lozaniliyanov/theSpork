package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.RestaurantEntity;
import bg.softuni.thespork.model.service.RestaurantServiceModel;

import java.util.List;

public interface RestaurantService {
    void seedRestaurants();

    void addRestaurant(RestaurantServiceModel restaurantServiceModel);

    RestaurantServiceModel findById(Long id);

    RestaurantEntity findByName(String name);

    List<RestaurantServiceModel> findAllRestaurants();

    List<RestaurantServiceModel> findAllUserRestaurants(String username);

    void deleteRestaurant(Long id);

    RestaurantServiceModel editRestaurantInfo(RestaurantServiceModel restaurantServiceModel, Long id);
}
