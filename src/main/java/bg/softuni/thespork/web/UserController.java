package bg.softuni.thespork.web;

import bg.softuni.thespork.model.binding.UserEditProfileBindingModel;
import bg.softuni.thespork.model.binding.UserPasswordChangeBindingModel;
import bg.softuni.thespork.model.binding.UserRegistrationBindingModel;
import bg.softuni.thespork.model.service.UserServiceModel;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(ModelMapper modelMapper, UserService userService, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("userRegistrationBindingModel")
    public UserRegistrationBindingModel createRegisterBindingModel() {
        return new UserRegistrationBindingModel();
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
            return "redirect:/users/register";
        }
        if (userService.existsByUsername(userRegistrationBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("existsByUsername", true);
            return "redirect:/users/register";
        }
        if (userService.existsByEmail(userRegistrationBindingModel.getEmail())) {
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("existsByEmail", true);
            return "redirect:/users/register";
        }
        UserServiceModel userServiceModel = modelMapper.map(userRegistrationBindingModel, UserServiceModel.class);
        userService.registerAndLoginUser(userServiceModel);
        return "redirect:/home";
    }

    @GetMapping("/user-profile-page")
    public String profilePage(Model model, Principal principal) {
        UserServiceModel userServiceModel = userService.findByUsername(principal.getName());
        UserEditProfileBindingModel userEditProfileBindingModel = modelMapper.map(userServiceModel, UserEditProfileBindingModel.class);
        if (!model.containsAttribute("userEditProfileBindingModel")) {
            model.addAttribute("userEditProfileBindingModel", userEditProfileBindingModel);
        }
        model.addAttribute("username", principal.getName());
        return "user-profile-page";
    }

    @PostMapping("/user-profile-page")
    public String profileEdit(@Valid @ModelAttribute("userEditProfileBindingModel") UserEditProfileBindingModel userEditProfileBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes,
                              Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userEditProfileBindingModel", userEditProfileBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userEditProfileBindingModel",
                    bindingResult);
            return "redirect:/users/user-profile-page";
        }
        UserServiceModel userServiceModel = modelMapper.map(userEditProfileBindingModel, UserServiceModel.class);
        String newUsername = userEditProfileBindingModel.getUsername();
        userService.updateProfile(userServiceModel, principal.getName(), newUsername);

        return "redirect:/users/login";
    }

    @GetMapping("/user-password-change")
    public String changePassword(Model model) {
        if (!model.containsAttribute("userPasswordChangeBindingModel")) {
            model.addAttribute("userPasswordChangeBindingModel", new UserPasswordChangeBindingModel());
        }
        return "user-password-change";
    }

    @PostMapping("/user-password-change")
    public String changePasswordConfirm(@Valid @ModelAttribute("userPasswordChangeBindingModel") UserPasswordChangeBindingModel userPasswordChangeBindingModel,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) {
        if (userPasswordChangeBindingModel.getPassword().isBlank() || userPasswordChangeBindingModel.getNewPassword().isBlank() || userPasswordChangeBindingModel.getConfirmNewPassword().isBlank()) {
            bindingResult.rejectValue("password", "error.userPasswordChangeBindingModel", "Please fill out all fields!");
        }
        if (!this.passwordEncoder.matches(userPasswordChangeBindingModel.getPassword(), userService.findUserByUsername(principal.getName()).getPassword())) {
            bindingResult.rejectValue("oldPassword", "error.userPasswordChangeBindingModel", "Wrong password!");
        }
        if (!userPasswordChangeBindingModel.getNewPassword().equals(userPasswordChangeBindingModel.getConfirmNewPassword())) {
            bindingResult.rejectValue("confirmNewPassword", "error.userPasswordChangeBindingModel", "Passwords don't match!");
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userPasswordChangeBindingModel", userPasswordChangeBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userPasswordChangeBindingModel"
                    , bindingResult);
            return "redirect:/users/user-password-change";
        }
        UserServiceModel userServiceModel = modelMapper.map(userPasswordChangeBindingModel, UserServiceModel.class);
        String newPassword = userPasswordChangeBindingModel.getNewPassword();
        userService.changePassword(userServiceModel, newPassword, principal.getName());
        return "redirect:/users/login";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                      String username,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", username);

        return "redirect:/users/login";
    }
}
