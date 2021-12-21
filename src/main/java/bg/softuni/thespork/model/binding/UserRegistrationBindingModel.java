package bg.softuni.thespork.model.binding;

import bg.softuni.thespork.validators.FieldMatch;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword")
public class UserRegistrationBindingModel {

    @NotEmpty(message = "This field is required!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long!")
    private String username;
    @NotEmpty(message = "This field is required!")
    @Email
    private String email;
    @NotEmpty(message = "This field is required!")
    @Size(min = 2, max = 20, message = "Surname must be between 2 and 20 characters long!")
    private String surname;
    @NotNull(message = "This field is required!")
    @Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String password;
    @NotNull(message = "This field is required!")
    private String confirmPassword;

    public UserRegistrationBindingModel() {

    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserRegistrationBindingModel setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
