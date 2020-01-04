package fundraisingapp.Base.Service;

import fundraisingapp.Auth.Model.User;
import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    User getAuthenticatedUser();
}
