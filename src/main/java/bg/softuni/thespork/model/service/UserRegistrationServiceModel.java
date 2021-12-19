package bg.softuni.thespork.model.service;

public class UserRegistrationServiceModel {

    private String username;
    private String email;
    private String surname;
    private String password;

    public UserRegistrationServiceModel() {

    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserRegistrationServiceModel setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
