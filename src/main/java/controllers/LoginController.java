package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/loginPage")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/accessDenied")
    public String getAccessDeniedPage(){
        return "accessDenied";
    }

    @RequestMapping("/loginFailure")
    public String getLoginFailurePage(){
        return "loginFailure";
    }
}
