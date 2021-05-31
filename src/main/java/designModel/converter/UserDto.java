package designModel.converter;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:50
 * @since JDK1.8
 */
public class UserDto {
    private  String firstName;
    private  String lastName;
    private  boolean active;
    private  String email;

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


    public UserDto(String firstName, String lastName, boolean active, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", email='" + email + '\'' +
                '}';
    }
}
