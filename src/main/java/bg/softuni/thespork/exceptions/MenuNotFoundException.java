package bg.softuni.thespork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Menu with this id not found")
public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException() {

    }

    public MenuNotFoundException(String message) {
        super(message);
    }
}