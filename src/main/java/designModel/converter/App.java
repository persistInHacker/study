package designModel.converter;

import java.util.List;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:51
 * @since JDK1.8
 */
public class App {

    public static void main(String[] args) {

        designModel.converter.UserConverter userConverter = new designModel.converter.UserConverter();
        designModel.converter.UserDto dtoUser = new designModel.converter.UserDto("John", "Doe", true, "whatever[at]wherever.com");
        designModel.converter.User user = userConverter.convertFromDto(dtoUser);
        System.out.println(user);

        var users = List.of(
                new designModel.converter.User("Camile", "Tough", false, "124sad"),
                new designModel.converter.User("Marti", "Luther", true, "42309fd"),
                new designModel.converter.User("Kate", "Smith", true, "if0243")
        );

        users.stream().map(designModel.converter.User::toString).forEach(System.out::println);

        List<designModel.converter.UserDto> dtoEntities = userConverter.convertFromEntities(users);
        dtoEntities.stream().map(designModel.converter.UserDto::toString).forEach(System.out::println);


    }
}
