package fundraisingapp.Base.Dto;

import fundraisingapp.Base.Validator.MatchingPassword;
import fundraisingapp.Base.Validator.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MatchingPassword
public class UserDto {
    @NotNull(message = "Name should not be null.")
    @NotEmpty(message = "Name should not be empty.")
    private String name;

    @NotNull(message = "Email address should not be null")
    @NotEmpty(message = "Email should not be empty.")
    @ValidEmail
    private String email;

    @NotNull(message = "Password should not be null")
    @NotEmpty(message = "Password should not be empty.")
    private String password;

    @NotNull(message = "Matching password should not be null")
    @NotEmpty(message = "Matching password should not be empty.")
    private String matchingPassword;

    public UserDto(){}

    public UserDto(String name,String email, String password, String matchingPassword)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
