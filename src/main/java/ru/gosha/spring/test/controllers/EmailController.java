package ru.gosha.spring.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ru.gosha.spring.test.api.EmailDTO;
import ru.gosha.spring.test.api.UserInfoDTO;
import ru.gosha.spring.test.service.LCAppEmailServiceImpl;
import ru.gosha.spring.test.service.LCAppServiceImpl;

import java.util.logging.Logger;

@Controller
public class EmailController {

    Logger logger = Logger.getLogger(EmailController.class.getName());
    @Autowired
    private LCAppEmailServiceImpl lcAppEmailService;


    @RequestMapping("/sendEmail")
    public String sendEmail(Model model){

        model.addAttribute("emailDTO", new EmailDTO());

        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfo, @ModelAttribute("emailDTO") EmailDTO emailDTO){
        try {
            lcAppEmailService.sendEmail(userInfo.getUserName(), emailDTO.getUserEmail(), userInfo.getResult());
        }catch (Exception e){
            logger.info("SendEmail exception is: "+ e);
        }

        return "process-email-page";
    }

    private void sendEmail(String userEmail, String friend) {
    }
}
