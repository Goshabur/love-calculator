package ru.gosha.spring.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.gosha.spring.test.api.UserInfoDTO;
import ru.gosha.spring.test.service.LCAppServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@SessionAttributes("userInfo")
@Controller
public class LCAppController {

    @Autowired
    private LCAppServiceImpl lcAppService;

    @RequestMapping("/")
    public String showHomePage(Model model){

        model.addAttribute("userInfo", new UserInfoDTO()); // manually

        /*UserInfoDTO userInfoDTO = new UserInfoDTO();
        model.addAttribute("userInfo", userInfoDTO);*/


//        if (request.getCookies().length > 1) {
//            Cookie[] cookies = request.getCookies();
//            userInfoDTO.setUserName(cookies[1].getValue());
//        }


        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String showResultPage(Model model , @Valid UserInfoDTO userInfoDTO, BindingResult result){ // @Valid - to trigger the validation

        model.addAttribute("userInfo", userInfoDTO);
        model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo",result);
        System.out.println(userInfoDTO.isTermAndCondition());

        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError error: list){
                System.out.println(error);
            }
            return "home-page";
        }

        String LCAppResult = lcAppService.calculateLove(userInfoDTO.getUserName(),userInfoDTO.getCrushName());
        userInfoDTO.setResult(LCAppResult);

        //Research
        // 1) one more turn-on-ur-cookie page
        // 2) encoding url

//        HttpSession session = request.getSession();
//        session.setAttribute("userName", userInfoDTO.getUserName());
//        session.setMaxInactiveInterval(120);



//        //Create a cookie for user name
//
//        Cookie theCookie = new Cookie("lcApp.userName", userInfoDTO.getUserName());
//        theCookie.setMaxAge(60*60*24);
//
//        // add the cookie to the response
//
//        response.addCookie(theCookie);

        // write the service which will calculate love between user and crush
        return "result-page";
        //model.addAttribute("userInfo", userInfoDTO);
        //model.addAttribute("crushName", userInfoDTO.getCrushName());
    }

}
