package bg.softuni.thespork.model.view;

public class UserViewModel {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String title;
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

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public UserViewModel setTitle(String title) {
        this.title = title;
        return this;
    }
}