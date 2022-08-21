package bg.softuni.thespork.model.binding;

import bg.softuni.thespork.model.entities.enums.Title;
import bg.softuni.thespork.validators.FieldMatch;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@FieldMatch(first = "password", second = "confirmPassword")
public class UserRegistrationBindingModel {
    @NotBlank(message = "This field if required!")
    @Length(min = 2, max = 20, message = "First name must be between 2 and 20 character long")
    private String firstName;
    @NotBlank(message = "This field is required!")
    @Length(min = 2, max = 20, message = "Last name must be between 2 and 20 character long")
    private String lastName;
    @NotNull(message = "Please select a title")
    private Title title;
    @NotBlank(message = "This field is required!")
    @Length(min = 3, max = 20, message = "Username must be between 3 and 20 characters long!")
    private String username;
    @NotBlank(message = "This field is required!")
    @Email
    private String email;
    @NotNull(message = "This field is required!")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String password;
    @NotNull(message = "This field is required!")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String confirmPassword;
    private String profilePic;

    public UserRegistrationBindingModel() {

    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public UserRegistrationBindingModel setTitle(Title title) {
        this.title = title;
        return this;
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

    public String getProfilePic() {
        return profilePic;
    }

    public UserRegistrationBindingModel setProfilePic(String profilePic) {
        this.profilePic = profilePic;
        return this;
    }
}
