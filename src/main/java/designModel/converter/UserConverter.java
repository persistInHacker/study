package main.java.designModel.converter;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:52
 * @since JDK1.8
 */
public class UserConverter extends Converter<UserDto, User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static UserDto convertToDto(User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.isActive(), user.getUserId());
    }

    private static User convertToEntity(UserDto dto) {
        return new User(dto.getFirstName(), dto.getLastName(), dto.isActive(), dto.getEmail());
    }


}
