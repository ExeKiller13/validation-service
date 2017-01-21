package alokhin.service.controller;

import alokhin.service.model.UserBean;
import alokhin.service.validators.EmailValidator;
import alokhin.service.validators.PasswordValidator;
import alokhin.service.validators.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET) // Return registration form
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Register Details");
        return "register"; // Registration .jsp page
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("userBean") UserBean userBean) {

        Validator emailValidator = new EmailValidator();
        Validator passwordValidator = new PasswordValidator();

        boolean emailState = emailValidator.validate(userBean.getEmail()); // Flag showing that email is correct
        boolean passwordState = passwordValidator.validate(userBean.getPassword()); // Flag showing that password is correct

        if (!emailState) {
            model.addAttribute("error", emailValidator.getState());
            return "register"; // Error
        }
        if (!passwordState) {
            model.addAttribute("error", passwordValidator.getState());
            return "register"; // Error
        }

        model.addAttribute("msg", userBean.getEmail()); // Validation successful
        return "success"; // Successful .jsp page
    }
}