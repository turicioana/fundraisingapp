package fundraisingapp.Auth.Service;

import fundraisingapp.Auth.CustomException.EmailExistingException;
import fundraisingapp.Auth.Dto.UserDto;
import fundraisingapp.Auth.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IUserService
{
    User newUserAccount(UserDto userDto, PasswordEncoder passwordEncoder) throws EmailExistingException;
    User getUserByEmail(String email);
    void changeUserRole(User user, String role);
}
