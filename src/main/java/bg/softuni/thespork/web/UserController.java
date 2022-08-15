package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.UserRegistrationBindingModel;
import bg.softuni.thespork.model.service.UserRegistrationServiceModel;
import bg.softuni.thespork.model.view.UserViewModel;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("registrationBindingModel")
    public UserRegistrationBindingModel createRegisterBindingModel() {
        return new UserRegistrationBindingModel();
    }

    @ModelAttribute("userViewModelForProfilePage")
    public UserViewModel createUserViewModel() {
        return new UserViewModel();
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAndLoginUser(
            @Valid UserRegistrationBindingModel userRegistrationBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegistrationBindingModel", bindingResult);
            return "redirect:/register";
        }
        if (userService.userNameExists(userRegistrationBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("userExistsError", true);
            return "redirect:/register";
        }
        if (userService.emailExists(userRegistrationBindingModel.getEmail())) {
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("emailExistsError", true);
            return "redirect:/register";
        }
        UserRegistrationServiceModel userRegistrationServiceModel = modelMapper.map(userRegistrationBindingModel, UserRegistrationServiceModel.class);
        userService.registerAndLoginUser(userRegistrationServiceModel);
        return "redirect:/home";
    }

    @GetMapping("/user-profile-page/{id}")
    public String userProfilePage(@PathVariable Long id, Model model) {
        UserViewModel userViewModel = modelMapper.map(userService.findById(id), UserViewModel.class);
        model.addAttribute("user", userViewModel);

        return "user-profile-page";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                      String username,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", username);


        return "redirect:/login";
    }
}
