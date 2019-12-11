package fundraisingapp.Base.Service;

import fundraisingapp.Base.CustomException.EmailExistingException;
import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IUserService
{
    User newUserAccount(UserDto userDto, PasswordEncoder passwordEncoder) throws EmailExistingException;
    User getUserByEmail(String email);
}
