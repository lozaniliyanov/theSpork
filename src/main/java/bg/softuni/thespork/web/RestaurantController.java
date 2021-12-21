package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.RestaurantAddBindingModel;
import bg.softuni.thespork.model.entities.UserRoleEntity;
import bg.softuni.thespork.model.service.RestaurantAddServiceModel;
import bg.softuni.thespork.repository.UserRoleRepository;
import bg.softuni.thespork.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final ModelMapper modelMapper;
    private final RestaurantService restaurantService;

    public RestaurantController(ModelMapper modelMapper,
                                RestaurantService restaurantService) {
        this.modelMapper = modelMapper;
        this.restaurantService = restaurantService;
    }

    @ModelAttribute("restaurantAddBindingModel")
    public RestaurantAddBindingModel createBindingModel() {
        return new RestaurantAddBindingModel();
    }

    @GetMapping("/add")
    public String addRestaurant() {
        return "restaurant-add";
    }
    @PostMapping("/add")
    public String addRestaurant(@Valid RestaurantAddBindingModel restaurantAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                @AuthenticationPrincipal UserDetails principal) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("restaurantAddBindingModel", restaurantAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.restaurantAddBindingModel", bindingResult);
            return "redirect:restaurant-add";
        }
        RestaurantAddServiceModel restaurantAddServiceModel = modelMapper.map(restaurantAddBindingModel, RestaurantAddServiceModel.class);
        restaurantAddServiceModel.setOwner(principal.getUsername());
        restaurantService.addRestaurant(restaurantAddServiceModel);
        return "redirect:/home";
    }
}
