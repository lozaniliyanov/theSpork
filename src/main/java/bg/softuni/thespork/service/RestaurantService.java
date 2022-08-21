package bg.softuni.thespork.service;

import bg.softuni.thespork.model.service.RestaurantServiceModel;

import java.util.List;

public interface RestaurantService {

    void addRestaurant(RestaurantServiceModel restaurantServiceModel, String username);

    List<RestaurantServiceModel> findAllUserRestaurants(String username);

    List<RestaurantServiceModel> findAllRestaurants();

    void deleteRestaurant(Long id);

    RestaurantServiceModel editRestaurantInfo(RestaurantServiceModel restaurantServiceModel, Long id);

    //    List<RestaurantViewModel> getAllRestaurants();
    int RestaurantsCount();

    boolean existsByRestaurantName(String restaurantName);

    RestaurantServiceModel findByRestaurantName(String restaurantName);
}
