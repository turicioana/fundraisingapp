package fundraisingapp.Base.Service;

import fundraisingapp.Base.CustomException.EmailExistingException;
import fundraisingapp.Base.Dto.UserDto;
import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Repositories.IUserRepository;
import fundraisingapp.Base.Service.Mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserMapper userMapper;

    public UserService(IUserRepository repository, IUserMapper userMapper) {
        this.userRepository = repository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public User newUserAccount(UserDto userDto) throws EmailExistingException {
        if( emailAlreadyExists(userDto.getEmail()))
        {
            throw new EmailExistingException("Email already used");
        }
        User user = userMapper.UserDtoToUser(userDto);
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
}
