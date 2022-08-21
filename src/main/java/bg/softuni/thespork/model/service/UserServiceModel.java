package bg.softuni.thespork.model.service;

import bg.softuni.thespork.model.entities.enums.Title;

import java.util.List;

public class UserServiceModel {

    private String firstName;
    private String lastName;
    private Title title;
    private String username;
    private String email;
    private String password;
    private String profilePic;
    private List<ReviewServiceModel> reviews;

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

    public String getProfilePic() {
        return profilePic;
    }

    public UserServiceModel setProfilePic(String profilePic) {
        this.profilePic = profilePic;
        return this;
    }

    public List<ReviewServiceModel> getReviews() {
        return reviews;
    }

    public UserServiceModel setReviews(List<ReviewServiceModel> reviews) {
        this.reviews = reviews;
        return this;
    }
}
