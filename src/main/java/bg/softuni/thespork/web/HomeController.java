package bg.softuni.thespork.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "home";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
