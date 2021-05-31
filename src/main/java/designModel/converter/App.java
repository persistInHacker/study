package main.java.designModel.converter;

import java.util.List;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:51
 * @since JDK1.8
 */
public class App {

    public static void main(String[] args) {

        UserConverter userConverter = new UserConverter();
        UserDto dtoUser = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
        User user = userConverter.convertFromDto(dtoUser);
        System.out.println(user);

        var users = List.of(
                new User("Camile", "Tough", false, "124sad"),
                new User("Marti", "Luther", true, "42309fd"),
                new User("Kate", "Smith", true, "if0243")
        );

        users.stream().map(User::toString).forEach(System.out::println);

        List<UserDto> dtoEntities = userConverter.convertFromEntities(users);
        dtoEntities.stream().map(UserDto::toString).forEach(System.out::println);


    }
}
