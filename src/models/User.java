package models;

/**
 *
 * @author William
 */
public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String contactDetails;
    private Role role;

    public User(int id, String userName, String email, String password, String contactDetails, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.contactDetails = contactDetails;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
