package bg.softuni.thespork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Incorrect old password")
public class UserPasswordIncorrectException extends RuntimeException {
    public UserPasswordIncorrectException() {

    }

    public UserPasswordIncorrectException(String message) {
        super(message);
    }
}
