package fundraisingapp.Base.Controller;

import fundraisingapp.Base.CustomException.EmailExistingException;
import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.GenericResponse;
import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Service.IUserService;
import fundraisingapp.Base.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private final IUserService userService;

    UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<GenericResponse> register(@RequestBody UserDto userDto){
        User registeredUser = createUserAccount(userDto);
        if(registeredUser ==  null)
        {
            try {
                throw new EmailExistingException();
            } catch (EmailExistingException e) {
                return new ResponseEntity(new GenericResponse("This email already exists", true),HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(new GenericResponse("Account successfully created", false),HttpStatus.CREATED);
    }

    private User createUserAccount(UserDto userDto)
    {
        User registeredUser = null;
        try{
            registeredUser =  userService.newUserAccount(userDto);
        } catch(EmailExistingException e){
            return null;
        }
        return registeredUser;
    }
}
