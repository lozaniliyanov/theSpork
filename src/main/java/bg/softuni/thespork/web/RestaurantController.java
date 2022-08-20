package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.RestaurantAddBindingModel;
import bg.softuni.thespork.model.entities.enums.Cuisine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    @GetMapping("/add")
    public String addRestaurant(Model model) {
        if (!model.containsAttribute("restaurantAddBindingModel")) {
            model.addAttribute("restaurantAddBindingModel", new RestaurantAddBindingModel());
            model.addAttribute("cuisines", Cuisine.values());
        }
        return "restaurant-add";
    }

}
