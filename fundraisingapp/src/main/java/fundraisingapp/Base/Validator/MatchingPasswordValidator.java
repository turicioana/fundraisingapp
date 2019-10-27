package fundraisingapp.Base.Validator;

import fundraisingapp.Base.Dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchingPasswordValidator implements ConstraintValidator<MatchingPassword,Object> {
    @Override
    public void initialize(MatchingPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDto user = (UserDto) o;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
