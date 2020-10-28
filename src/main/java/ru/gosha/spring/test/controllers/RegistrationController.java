package ru.gosha.spring.test.controllers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gosha.spring.test.api.CommunicationDTO;
import ru.gosha.spring.test.api.Phone;
import ru.gosha.spring.test.api.UserRegistrationDTO;
import ru.gosha.spring.test.formatter.PhoneNumberFormatter;
import ru.gosha.spring.test.propertyeditor.NamePropertyEditor;
import ru.gosha.spring.test.validator.EmailValidator;
import ru.gosha.spring.test.validator.UserNameValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("registerInfo") UserRegistrationDTO userRegistrationDTO){
        System.out.println("inside showRegistrationPage method");
//        Phone phone = new Phone();
//        phone.setCountryCode("91");
//        phone.setUserNumber("22334455");
//        CommunicationDTO communicationDTO = new CommunicationDTO();
//        communicationDTO.setPhone(phone);
//        userRegistrationDTO.setCommunicationDTO(communicationDTO);
        return "user-registration-page";
    }

    @RequestMapping("/registration-success")
    public String processUserReg(@Valid @ModelAttribute("registerInfo")UserRegistrationDTO userRegistrationDTO, BindingResult result){
        System.out.println("inside processUserReg method");
        System.out.println("Name value entered by user is " + "|" + userRegistrationDTO.getName() + "|");

        // how to call my email validator from my controller method, but we can do it in another way:1) add @Component to EmailValidator
        //EmailValidator validator = new EmailValidator();                                           2) in RegistrationController create field: private EmailValidator
        //validator.validate(userRegistrationDTO, result);                                           3) mark this field as @Autowired and call .validate

        if (result.hasErrors()){
            System.out.println("My page has errors");
            List<ObjectError> allErrors = result.getAllErrors();
            for(ObjectError error: allErrors){
                System.out.println(error);
            }
            return "user-registration-page";
        }

        return "registration-success";
    }

    @InitBinder // метод initBinder инициализирует WebDataBinder, точнее сам spring это делает, когда видит @InitBinder -> мы получаем доступ к объекту
    public void initBinder(WebDataBinder binder){ // Этот метод инициализирует привязку               //WebDataBinder, т.е. к binder и теперь можем добавлять
                                                  // данных(Initialize binding),                      // editors для наших property(полей)
                                                  // он прогоняется каждый раз перед привязкой        // responsible for default DataBinding
                                                                                                      //WebDataBinder : "Binder that is responsible of setting
                                                                                                      // property values on to a target object"

        System.out.println("Inside the init binder method");//данных: перед переходом на страницу регестрации(где происходит binding), перед переходом
                                                            // на страницу с результатом - всегда мы в начале выполняем этот метод инициализируя привязку данных

        //binder.setDisallowedFields("userName");//Мы не хотим чтобы c нашей property "name" происходил binding
                                            //т.е. мы не хотим, чтобы происходила привязка данных по полю "name"

        StringTrimmerEditor editor = new StringTrimmerEditor(true);// ещё один метод изменения привязки данных - стирание пробелов,
        binder.registerCustomEditor(String.class, "name",editor);        //т.е. чтобы пользователь не вводил пробелы вместо данных - для поля String name
                                                                                // StringTrimmerEditor is converting whitespaces to null

        //Теперь создадим свой PropertyEditor : NamePropertyEditor
        //NamePropertyEditor nameEditor = new NamePropertyEditor();
        //binder.registerCustomEditor(String.class, nameEditor);



        //binder.addCustomFormatter(new PhoneNumberFormatter());


        //добавляем наш Validator
        UserNameValidator userNameValidator = new UserNameValidator();
        EmailValidator emailValidator = new EmailValidator();
        binder.addValidators(userNameValidator, emailValidator);




    }

}
