package ru.gosha.spring.test.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.gosha.spring.test.api.UserRegistrationDTO;


public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        String email = ((UserRegistrationDTO)object).getCommunicationDTO().getEmail();
        if(!email.endsWith("@seleniumexpress.com")){
            errors.rejectValue("communicationDTO.email", "email.invalidSyntax");
        }
    }
}
