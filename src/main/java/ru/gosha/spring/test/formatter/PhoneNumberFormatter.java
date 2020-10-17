package ru.gosha.spring.test.formatter;

import org.springframework.format.Formatter;
import ru.gosha.spring.test.api.Phone;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String completePhoneNumber, Locale locale) throws ParseException { //этот метод форматирует - превращает строку в объект Phone
        System.out.println("inside the parse method of the PhoneFormatter");
        String[] phoneNumberArray = completePhoneNumber.split("-");
        Phone phone = new Phone();
        if (completePhoneNumber.indexOf('-') == -1 || completePhoneNumber.startsWith("-")|| completePhoneNumber.endsWith("-")) {
            if (completePhoneNumber.startsWith("-")) {
                phone.setCountryCode("91");
                phone.setUserNumber(phoneNumberArray[1]);
            } else {
                phone.setCountryCode("91");
                phone.setUserNumber(phoneNumberArray[0]);
            }
        } else
            phone.setCountryCode(phoneNumberArray[0]);
            phone.setUserNumber(phoneNumberArray[1]);

        return phone;
    }

    @Override
    public String print(Phone phone, Locale locale) { //этот метод форматирует - превращает объект Phone в строку
        System.out.println("inside the print method of formatter class");
        String str = phone.getCountryCode() + "-" + phone.getUserNumber();
        return str;
    }
}
