package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;

public interface IUserMapper {
    User UserDtoToUser(UserDto userDto);
    UserDto UserToUserDto(User user);
}
