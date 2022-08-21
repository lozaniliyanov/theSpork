package bg.softuni.thespork.model.binding;

import bg.softuni.thespork.model.entities.enums.Title;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserEditProfileBindingModel {
    @NotBlank(message = "This field if required!")
    @Length(min = 2, max = 20, message = "First name must be between 2 and 20 character long")
    private String firstName;
    @NotBlank(message = "This field is required!")
    @Length(min = 2, max = 20, message = "Last name must be between 2 and 20 character long")
    private String lastName;
    @NotBlank(message = "This field is required!")
    @Length(min = 3, max = 20, message = "Username must be between 3 and 20 characters long!")
    private String username;
    @NotNull
    private Title title;
    @Email
    @NotBlank(message = "This field is required!")
    private String email;
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String password;
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String newPassword;
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String confirmNewPassword;
    private MultipartFile profilePic;

    public UserEditProfileBindingModel() {

    }

    public String getFirstName() {
        return firstName;
    }

    public UserEditProfileBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEditProfileBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEditProfileBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public UserEditProfileBindingModel setTitle(Title title) {
        this.title = title;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEditProfileBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEditProfileBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public UserEditProfileBindingModel setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public UserEditProfileBindingModel setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
        return this;
    }

    public MultipartFile getProfilePic() {
        return profilePic;
    }

    public UserEditProfileBindingModel setProfilePic(MultipartFile profilePic) {
        this.profilePic = profilePic;
        return this;
    }
}
