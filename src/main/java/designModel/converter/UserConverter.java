package designModel.converter;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:52
 * @since JDK1.8
 */
public class UserConverter extends Converter<designModel.converter.UserDto, User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static designModel.converter.UserDto convertToDto(User user) {
        return new designModel.converter.UserDto(user.getFirstName(), user.getLastName(), user.isActive(), user.getUserId());
    }

    private static User convertToEntity(designModel.converter.UserDto dto) {
        return new User(dto.getFirstName(), dto.getLastName(), dto.isActive(), dto.getEmail());
    }


}
