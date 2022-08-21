package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.exceptions.RestaurantNotFoundException;
import bg.softuni.thespork.model.entities.RestaurantEntity;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.service.UserServiceModel;
import bg.softuni.thespork.repository.RestaurantRepository;
import bg.softuni.thespork.service.RestaurantService;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void addRestaurant(RestaurantServiceModel restaurantServiceModel, String username) {
        restaurantServiceModel.setOwner(username);
        RestaurantEntity restaurant = modelMapper.map(restaurantServiceModel, RestaurantEntity.class);
        restaurant.setOwner(userService.findByName(username));
        restaurantRepository.saveAndFlush(restaurant);
    }

    @Override
    public List<RestaurantServiceModel> findAllUserRestaurants(String username) {
        UserServiceModel owner = userService.findUserByUsername(username);
        List<RestaurantEntity> userRestaurants = restaurantRepository.findAllByOwner_Username(owner.getUsername());
        return userRestaurants.stream().map(restaurantEntity -> modelMapper.map(restaurantEntity, RestaurantServiceModel.class)).collect(Collectors.toList());
    }


    @Override
    public void deleteRestaurant(Long id) {

    }

    @Override
    public RestaurantServiceModel editRestaurantInfo(RestaurantServiceModel restaurantServiceModel, Long id) {
        return null;
    }

    @Override
    public int RestaurantsCount() {
        return restaurantRepository.countRestaurantEntities();
    }

    @Override
    public boolean existsByRestaurantName(String restaurantName) {
        return this.restaurantRepository.existsByRestaurantName(restaurantName);
    }

    @Override
    public RestaurantServiceModel findByRestaurantName(String restaurantName) {
        RestaurantEntity restaurant = restaurantRepository.
                findByRestaurantName(restaurantName).
                orElseThrow(() -> new RestaurantNotFoundException(
                        String.format("Restaurant with name %s not found", restaurantName)));
        return modelMapper.map(restaurant, RestaurantServiceModel.class);


    }

    @Override
    public List<RestaurantServiceModel> findAllRestaurants() {
        return this.restaurantRepository.findAll().stream().map(restaurant -> this.modelMapper.map(restaurant, RestaurantServiceModel.class)).collect(Collectors.toList());
    }
}


























