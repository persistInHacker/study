package designModel.converter;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:50
 * @since JDK1.8
 */
public class User {
    private  String firstName;
    private  String lastName;
    private  boolean active;
    private  String userId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User(String firstName, String lastName, boolean active, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", userId='" + userId + '\'' +
                '}';
    }
}
