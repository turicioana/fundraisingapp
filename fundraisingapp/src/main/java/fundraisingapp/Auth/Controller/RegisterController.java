package fundraisingapp.Auth.Controller;

import fundraisingapp.Auth.CustomException.EmailExistingException;
import fundraisingapp.Auth.Dto.UserDto;
import fundraisingapp.Auth.GenericResponse;
import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Service.IUserService;
import fundraisingapp.Auth.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private final IUserService userService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    RegisterController(UserService userService,PasswordEncoder passwordEncoder)
    {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<GenericResponse> register(@Valid @RequestBody UserDto userDto){
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    private User createUserAccount(UserDto userDto)
    {
        User registeredUser = null;
        try{
            registeredUser =  userService.newUserAccount(userDto, passwordEncoder);
        } catch(EmailExistingException e){
            return null;
        }
        return registeredUser;
    }
}
