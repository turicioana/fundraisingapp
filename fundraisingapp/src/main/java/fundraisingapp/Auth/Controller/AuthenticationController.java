package fundraisingapp.Auth.Controller;

import fundraisingapp.Auth.AuthenticationResponse;
import fundraisingapp.Auth.Dto.AuthenticationUserDto;
import fundraisingapp.Auth.Service.JWTokenService;
import fundraisingapp.Auth.Service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTokenService jwTokenService;

    @Autowired
    private JwtUserDetailsService userService;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationUserDto authenticationUserDto) throws Exception{
        authenticate(authenticationUserDto.getEmail(), authenticationUserDto.getPassword());
        System.out.println("Request facut");
        final UserDetails userDetails = userService.loadUserByUsername(authenticationUserDto.getEmail());

        final String token = jwTokenService.generateJWToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String email, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
}
