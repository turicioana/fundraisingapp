package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final IUserRepository userRepository;

    UserController(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserDto userDto){
        userRepository.save(new User(userDto.getName(), userDto.getEmail(),userDto.getPassword()));
        return "Customer is created";
    }
}
