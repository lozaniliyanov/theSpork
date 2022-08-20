package bg.softuni.thespork.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserPasswordChangeBindingModel {
    @NotNull(message = "This field is required!")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String password;
    @NotNull(message = "This field is required!")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String newPassword;
    @NotNull(message = "This field is required!")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 characters long!")
    private String confirmNewPassword;

    public UserPasswordChangeBindingModel() {

    }

    public String getPassword() {
        return password;
    }

    public UserPasswordChangeBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public UserPasswordChangeBindingModel setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public UserPasswordChangeBindingModel setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
        return this;
    }
}
