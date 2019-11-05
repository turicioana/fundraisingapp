package fundraisingapp.Base.Dto;

import fundraisingapp.Base.Model.Role;
import fundraisingapp.Base.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JWTUserDetails implements UserDetails {
    private User user;

    public JWTUserDetails(){}

    public JWTUserDetails(final User _user){
        this.user = _user;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> _auth = new HashSet<GrantedAuthority>();
        List<Role> _roles = null;

        if(user!=null){
            _roles.add(user.getRole());
        }
        if(_roles!=null){
            for(Role _role:_roles){
                _auth.add(new SimpleGrantedAuthority(_role.getName()));
            }
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
