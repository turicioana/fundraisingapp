package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IUserMapper {
    User UserDtoToUser(UserDto userDto, PasswordEncoder passwordEncoder);
    UserDto UserToUserDto(User user);
}
