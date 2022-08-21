package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.ReviewAddBindingModel;
import bg.softuni.thespork.model.entities.enums.PriceRange;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.service.ReviewServiceModel;
import bg.softuni.thespork.model.view.RestaurantViewModel;
import bg.softuni.thespork.service.RestaurantService;
import bg.softuni.thespork.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/reviews")
public class ReviewController {


    private final ModelMapper modelmapper;
    private ReviewService reviewService;
    private final RestaurantService restaurantService;

    public ReviewController(ModelMapper modelmapper, ReviewService reviewService, RestaurantService restaurantService) {
        this.modelmapper = modelmapper;
        this.reviewService = reviewService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("write-review/{restaurantName}")
    public String writeReview(@PathVariable String restaurantName, Model model) {
        RestaurantServiceModel restaurantServiceModel = restaurantService.findByRestaurantName(restaurantName);
        RestaurantViewModel restaurantViewModel = modelmapper.map(restaurantServiceModel, RestaurantViewModel.class);
        model.addAttribute("restaurantName", restaurantViewModel.getRestaurantName());
        return "write-review";
    }

    @PostMapping("/write-review/{restaurantName}")
    public String writeReviewConfirm(@PathVariable String restaurantName, @Valid @ModelAttribute("reviewAddBindingModel") ReviewAddBindingModel reviewAddBindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reviewAddBindingModel", reviewAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reviewAddBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("priceRange", PriceRange.values());
            return "redirect:" + restaurantName;
        }
        String username = principal.getName();
        RestaurantServiceModel restaurantServiceModel = restaurantService.findByRestaurantName(restaurantName);
        ReviewServiceModel reviewServiceModel = modelmapper.map(reviewAddBindingModel, ReviewServiceModel.class);
        reviewService.addReview(reviewServiceModel, username, restaurantServiceModel);
        return "redirect:" + restaurantName;
    }
}
