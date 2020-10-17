package ru.gosha.spring.test.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.gosha.spring.test.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

    //check if the UserNameValidator supports a given object
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationDTO.class.equals(aClass);
    }

    //we need to write our custom validation logic
    @Override
    public void validate(Object object, Errors errors) {
        //to check if the field is null(Spring framework class)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "User Name can not be empty");
        //userName should contain _
        String username = ((UserRegistrationDTO)object).getUserName();
        if(!username.contains("_")){
            errors.rejectValue("userName", "UserName.invalidString", "String must contain '_'");
        }
    }
}
