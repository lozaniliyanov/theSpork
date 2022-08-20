package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.RestaurantEntity;
import bg.softuni.thespork.model.entities.enums.Cuisine;
import bg.softuni.thespork.model.entities.enums.PriceRange;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.repository.RestaurantRepository;
import bg.softuni.thespork.service.RestaurantService;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;
    private final UserService userService;

    public RestaurantServiceImpl(ModelMapper modelMapper, RestaurantRepository restaurantRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public void seedRestaurants() {
        RestaurantEntity pikos = new RestaurantEntity().
                setRestaurantName("Pikos").
                setCuisine(Cuisine.MEXICAN).
                setPriceRange(PriceRange.$$$$).
                setRating(5.0).
                setOwner(userService.findByName("pikosOwner"));
        RestaurantEntity mamos = new RestaurantEntity().
                setRestaurantName("Mamos").
                setCuisine(Cuisine.AMERICAN).
                setPriceRange(PriceRange.$$$$).
                setRating(5.0).
                setOwner(userService.findByName("mamosOwner"));
        restaurantRepository.save(pikos);
        restaurantRepository.save(mamos);
    }


    @Override
    public void addRestaurant(RestaurantServiceModel restaurantServiceModel) {

    }

    @Override
    public RestaurantServiceModel findById(Long id) {
        return null;
    }

    @Override
    public RestaurantEntity findByName(String name) {
        return restaurantRepository.findByRestaurantName(name).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<RestaurantServiceModel> findAllRestaurants() {
        return null;
    }

    @Override
    public List<RestaurantServiceModel> findAllUserRestaurants(String username) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long id) {

    }

    @Override
    public RestaurantServiceModel editRestaurantInfo(RestaurantServiceModel restaurantServiceModel, Long id) {
        return null;
    }
}
