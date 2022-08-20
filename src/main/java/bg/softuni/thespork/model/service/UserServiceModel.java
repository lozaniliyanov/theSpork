package bg.softuni.thespork.model.service;

import bg.softuni.thespork.model.entities.enums.Title;

public class UserServiceModel {

    private String firstName;
    private String lastName;
    private Title title;
    private String username;
    private String email;
    private String password;

    public UserServiceModel() {

    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public UserServiceModel setTitle(Title title) {
        this.title = title;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
