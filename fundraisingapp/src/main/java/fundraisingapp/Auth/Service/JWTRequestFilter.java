package fundraisingapp.Auth.Service;

import fundraisingapp.Auth.Dto.JWTUserDetails;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTokenService jwTokenService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final  String requestHeader =  httpServletRequest.getHeader("Authorization");
        System.out.println("BBB " + requestHeader);
        String email = null;
        String jwtToken = null;
        if(requestHeader != null && requestHeader.startsWith("Bearer ")){
            jwtToken = requestHeader.substring(7);
            try{
                email = jwTokenService.getEmailFromToken(jwtToken);
            }catch(IllegalArgumentException e){
                System.out.println("unable to get the JWT token");
            }catch (ExpiredJwtException e){
                System.out.println("Token has expired");
            }
        }else {
            System.out.println("Token does not begin with Bearer");
        }
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            JWTUserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(email);
            if(jwTokenService.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken emailPasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                emailPasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(emailPasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
