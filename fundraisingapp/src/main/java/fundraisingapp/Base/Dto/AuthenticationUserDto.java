package fundraisingapp.Base.Dto;

import java.io.Serializable;

public class AuthenticationUserDto implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;
    private String email;
    private String password;

    public AuthenticationUserDto() {
    }

    public AuthenticationUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
