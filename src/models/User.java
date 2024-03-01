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
    private int age;
    private String address;
    private String phone;
    private Role role;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String userName, String email, String password, int age, String address, String phone, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.address = address;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
