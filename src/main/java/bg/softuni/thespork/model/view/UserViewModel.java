package bg.softuni.thespork.model.view;

public class UserViewModel {
    private String username;
    private String email;
    private String firstName;
    private String surname;

    public UserViewModel() {

    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserViewModel setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}