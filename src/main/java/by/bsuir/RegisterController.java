package by.bsuir;

import by.bsuir.db.user.User;
import by.bsuir.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/register")
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private ConversionService conversionService;

    @InitBinder(value = "userModel")
    public void userModelBinder(WebDataBinder binder) {
        binder.setConversionService(conversionService);
        binder.addValidators(RegisterService.getUserValidator(registerService));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("title", "Регистрация");
        model.addAttribute("userModel", new UserModel());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Validated @ModelAttribute("userModel") UserModel user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            User entity = new User();
            entity.setLogin(user.getLogin());
            entity.setPassword(user.getPassword());
            registerService.registerUser(entity);
            return "redirect:/home";
        } else {
            model.addAttribute("title", "Регистрация");
            model.addAttribute("userModel", user);
            return "register";
        }
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages");
        return messageSource;
    }
}
