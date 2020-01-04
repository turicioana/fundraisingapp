package fundraisingapp.Base.Service;

import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Service.IUserService;
import fundraisingapp.Base.Service.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    @Autowired
    private IUserService userService;

    public AuthenticationFacade(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return userService.getUserByEmail(currentUserName);
        }
        return null;
    }
}
