package fundraisingapp.Auth.Dto;

import fundraisingapp.Auth.Model.Role;
import fundraisingapp.Auth.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class JWTUserDetails implements UserDetails {
    private User user;

    private Collection<GrantedAuthority> authorities;

    public JWTUserDetails(final User _user){
        this.user = _user;
        this.authorities = getAuthorities();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> _auth = new HashSet<GrantedAuthority>();
        List<Role> _roles = new ArrayList<>();

        if(user!=null){
            _roles.add(user.getRole());
        }
        for(Role _role:_roles){
            _auth.add(new SimpleGrantedAuthority(_role.getName()));
        }
        return _auth;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        if(this.user == null){
            return null;
        }
        return this.user.getEmail();
    }

    public String getName() {
        if(this.user == null){
            return null;
        }
        return this.user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }

    public User getUser()
    {
        return user;
    }
}
