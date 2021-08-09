package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojos.MyUser;
import services.IUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getRegistrationForm")
    public String getSignupForm(Model model){
        model.addAttribute("myUser", new MyUser());
        return "signup";
    }

    @PostMapping("/register")
    public String signup(@Valid @ModelAttribute("myUser") MyUser myUser, BindingResult bindingResult, Model model){
        System.out.println("RegistrationController: MyUser: " + myUser);

        model.addAttribute("myUser", new MyUser());

        if(bindingResult.hasErrors()) {
            model.addAttribute("registrationError", "Username/password cannot be empty");
            System.out.println("RegistrationController: bindingResult.hasErrors()");
            return "signup";
        }
        if(this.userService.userExists(myUser.getUsername())){
            model.addAttribute("registrationError", "User already exists");
            model.addAttribute("myUser", new MyUser());
            System.out.println("RegistrationController: user exists");
            return "signup";
        }
        System.out.println("RegistrationController: trying to save");
        this.userService.save(myUser);
        return "signupConfirmation";
    }
}
