package by.bsuir;

import by.bsuir.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return UserModel.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.empty");
            }
        });
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("loginModel", new UserModel());
        modelMap.put("title", "Вход");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(
            @Validated @ModelAttribute("loginModel") UserModel loginModel,
            BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("loginModel", loginModel);
            model.addAttribute("title", "Вход");
            return "login";
        }
        boolean success = loginService.tryLogin(loginModel.getLogin(), loginModel.getPassword(), session);
        if (success)
            return "redirect:/home";
        else
            return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        loginService.logout(httpSession);
        return "redirect:/home";
    }
}
