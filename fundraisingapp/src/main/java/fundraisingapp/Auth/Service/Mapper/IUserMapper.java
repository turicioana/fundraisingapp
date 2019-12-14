package fundraisingapp.Auth.Service.Mapper;

import fundraisingapp.Auth.Dto.UserDto;
import fundraisingapp.Auth.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IUserMapper {
    User UserDtoToUser(UserDto userDto, PasswordEncoder passwordEncoder);
    UserDto UserToUserDto(User user);
}
