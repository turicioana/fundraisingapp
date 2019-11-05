package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.JWTUserDetails;
import fundraisingapp.Base.Model.Privilege;
import fundraisingapp.Base.Model.Role;
import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Repositories.IRoleRepository;
import fundraisingapp.Base.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private IRoleRepository roleRepository;

    public JwtUserDetailsService(IUserRepository userRepository, IUserService userService, MessageSource messages, IRoleRepository roleRepository){
        this.userRepository = userRepository;
        this.userService = userService;
        this.messages = messages;
        this.roleRepository = roleRepository;
    }

    @Override
    public JWTUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new JWTUserDetails(new User());
        }
        return new JWTUserDetails(new User(user.getEmail(),user.getPassword(),user.getRole(),user.isEnabled()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Role role) {

        return getGrantedAuthorities(getPrivileges(role));
    }

    private List<String> getPrivileges(Role role) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        collection.addAll(role.getPrivileges());
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
