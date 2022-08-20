package bg.softuni.thespork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User with this username not found")
public class UserWithUsernameNotFoundException extends RuntimeException {
    public UserWithUsernameNotFoundException() {

    }

    public UserWithUsernameNotFoundException(String message) {
        super(message);
    }
}
