package fundraisingapp.Auth.Service;

import fundraisingapp.Auth.CustomException.EmailExistingException;
import fundraisingapp.Auth.Dto.UserDto;
import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Repositories.IRoleRepository;
import fundraisingapp.Auth.Repositories.IUserRepository;
import fundraisingapp.Auth.Service.Mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserMapper userMapper;

    public UserService(IUserRepository repository, IUserMapper userMapper, IRoleRepository roleRepository) {
        this.userRepository = repository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public User newUserAccount(UserDto userDto, PasswordEncoder passwordEncoder) throws EmailExistingException {
        if( emailAlreadyExists(userDto.getEmail()))
        {
            throw new EmailExistingException("Email already used");
        }
        User user = userMapper.UserDtoToUser(userDto,passwordEncoder);
        user.setRole(roleRepository.findByName("admin"));
        return userRepository.save(user);
    }

    private boolean emailAlreadyExists(String email)
    {
        User user = userRepository.findByEmail(email);
        return (user != null);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void changeUserRole(User user, String role){
        User user1 = getUserByEmail(user.getEmail());
        user1.setRole(roleRepository.findByName(role));
        userRepository.save(user1);
    }
}
