package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;


    @PostMapping("/create")
    public String create(@RequestBody UserDto userDto){
        userRepository.save(new User(userDto.getName(), userDto.getEmail(),userDto.getPassword()));
        return "Customer is created";
    }
}
