package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.RestaurantAddBindingModel;
import bg.softuni.thespork.model.entities.enums.Cuisine;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.view.RestaurantViewModel;
import bg.softuni.thespork.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;

    public RestaurantController(RestaurantService restaurantService, ModelMapper modelMapper) {
        this.restaurantService = restaurantService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/restaurant-add")
    public String addRestaurant(Model model) {
        if (!model.containsAttribute("restaurantAddBindingModel")) {
            model.addAttribute("restaurantAddBindingModel", new RestaurantAddBindingModel());
            model.addAttribute("cuisines", Cuisine.values());
        }
        return "restaurant-add";
    }

    @PostMapping("/restaurant-add")
    public String addRestaurantConfirm(@Valid @ModelAttribute("restaurantAddBindingModel") RestaurantAddBindingModel restaurantAddBindingModel, BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("restaurantAddBindingModel", restaurantAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.restaurantAddBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("cuisines", Cuisine.values());
            return "redirect:/restaurants/restaurant-add";
        }
        if (restaurantService.existsByRestaurantName(restaurantAddBindingModel.getRestaurantName())) {
            redirectAttributes.addFlashAttribute("restaurantAddBindingModel", restaurantAddBindingModel);
            redirectAttributes.addFlashAttribute("existsByRestaurantName", true);
            return "redirect:/restaurants/restaurant-add";
        }
        String username = principal.getName();
        RestaurantServiceModel restaurantServiceModel = modelMapper.map(restaurantAddBindingModel, RestaurantServiceModel.class);
        restaurantService.addRestaurant(restaurantServiceModel, username);
        return "redirect:/";
    }

    @GetMapping("/user-restaurants")
    public String userRestaurants(Model model, Principal principal) {
        List<RestaurantServiceModel> allUserRestaurants = restaurantService.findAllUserRestaurants(principal.getName());
        List<RestaurantViewModel> allUserRestaurantViewModels = allUserRestaurants.stream().
                map(restaurantViewModel -> modelMapper.map(restaurantViewModel, RestaurantViewModel.class)).collect(Collectors.toList());
        model.addAttribute("allUserRestaurants", allUserRestaurantViewModels);
        return "/user-restaurants";
    }

    @GetMapping("/restaurants-all")
    public String allRestaurants(Model model) {
        int restaurantsCount = this.restaurantService.RestaurantsCount();
        List<RestaurantServiceModel> allRestaurants = restaurantService.findAllRestaurants();
        List<RestaurantViewModel> allRestaurantViewModels = allRestaurants.stream().
                map(restaurantViewModel -> modelMapper.map(restaurantViewModel, RestaurantViewModel.class)).collect(Collectors.toList());
        model.addAttribute("allRestaurants", allRestaurantViewModels);
        model.addAttribute("restaurantsCount", restaurantsCount);
        model.addAttribute("cuisine", Cuisine.values());
        return "restaurants-all";
    }
}
