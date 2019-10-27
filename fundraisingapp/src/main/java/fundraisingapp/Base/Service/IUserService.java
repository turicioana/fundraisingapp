package fundraisingapp.Base.Service;

import fundraisingapp.Base.CustomException.EmailExistingException;
import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;

public interface IUserService
{
    User newUserAccount(UserDto userDto) throws EmailExistingException;
}
