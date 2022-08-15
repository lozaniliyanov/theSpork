//package bg.softuni.thespork.service.impl;
//
//import bg.softuni.thespork.model.entities.RestaurantEntity;
//import bg.softuni.thespork.model.entities.UserEntity;
//import bg.softuni.thespork.model.entities.UserRoleEntity;
//import bg.softuni.thespork.model.entities.enums.UserRole;
//import bg.softuni.thespork.model.service.RestaurantAddServiceModel;
//import bg.softuni.thespork.repository.RestaurantRepository;
//import bg.softuni.thespork.repository.UserRepository;
//import bg.softuni.thespork.repository.UserRoleRepository;
//import bg.softuni.thespork.service.RestaurantService;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RestaurantServiceImpl implements RestaurantService {
//
//    private final RestaurantRepository restaurantRepository;
//    private final UserRepository userRepository;
//    private final UserRoleRepository userRoleRepository;
//    private final ModelMapper modelMapper;
//
//    public RestaurantServiceImpl(RestaurantRepository restaurantRepository,
//                                 UserRepository userRepository,
//                                 UserRoleRepository userRoleRepository,
//                                 ModelMapper modelMapper) {
//        this.restaurantRepository = restaurantRepository;
//        this.userRepository = userRepository;
//        this.userRoleRepository = userRoleRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public void addRestaurant(RestaurantAddServiceModel restaurantAddServiceModel) {
//        RestaurantEntity restaurantEntity = modelMapper.map(restaurantAddServiceModel, RestaurantEntity.class);
//        UserEntity owner = userRepository.findByUsername(restaurantAddServiceModel.getOwner()).orElseThrow(() ->
//                new IllegalArgumentException("Owner " + restaurantAddServiceModel.getOwner() + " could not be found"));
//        UserRoleEntity restaurantRole = userRoleRepository.findByRole(UserRole.RESTAURANT_OWNER).
//                orElseThrow(() -> new IllegalStateException("RESTAURANT role not found. Please seed the roles."));
//        owner.getRoles().add(restaurantRole);
//        userRepository.save(owner);
////        restaurantEntity.setOwner(owner);
//        restaurantRepository.save(restaurantEntity);
//    }
//}
