package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements IUserMapper {

    @Override
    public User UserDtoToUser(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);
        return user;
    }

    @Override
    public UserDto UserToUserDto(User user) {
        UserDto userDto =  new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
