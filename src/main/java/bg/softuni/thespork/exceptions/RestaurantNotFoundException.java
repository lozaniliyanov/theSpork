package bg.softuni.thespork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Restaurant with this name not found")
public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException() {

    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
