package ru.gosha.spring.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gosha.spring.test.api.EmailDTO;

import javax.servlet.http.HttpSession;

@Controller
public class EmailController {

    @RequestMapping("/sendEmail")
    public String sendEmail(Model model){

        model.addAttribute("emailDTO", new EmailDTO());

        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO){

//        String userName = (String) session.getAttribute("userName");
//        String newUserName = "Mr " + userName;
//        model.addAttribute("userName", newUserName);
        return "process-email-page";
    }
}
