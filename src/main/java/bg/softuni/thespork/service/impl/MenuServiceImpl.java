package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.MenuEntity;
import bg.softuni.thespork.repository.MenuRepository;
import bg.softuni.thespork.repository.RestaurantRepository;
import bg.softuni.thespork.service.MenuService;
import bg.softuni.thespork.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final RestaurantService restaurantService;
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuServiceImpl(RestaurantService restaurantService, MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.restaurantService = restaurantService;
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

//    @Override
//    public void seedMenus() {
//        MenuEntity pikosMenu = new MenuEntity().
//                setRestaurant(restaurantService.findByName("Pikos"));
//        MenuEntity mamosMenu = new MenuEntity().
//                setRestaurant(restaurantService.findByName("Mamos"));
//        menuRepository.save(pikosMenu);
//        RestaurantEntity pikos = restaurantService.findByName("Pikos").setMenuEntity(pikosMenu);
//        restaurantRepository.save(pikos);
//        menuRepository.save(mamosMenu);
//        RestaurantEntity mamos = restaurantService.findByName("Mamos").setMenuEntity(mamosMenu);
//        restaurantRepository.save(mamos);
//
//    }

    @Override
    public MenuEntity findById(Long id) {
        return null;
    }
}
