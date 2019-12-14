package by.bsuir;

import by.bsuir.db.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService userService;
    @Autowired
    private ConversionService conversionService;

    @InitBinder(value = "userModel")
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setConversionService(conversionService);
        webDataBinder.addValidators(RegisterService.getUserValidator(registerService));
    }

    @RequestMapping(value = "/user/{login}", method = RequestMethod.GET)
    public String userPage(@PathVariable("login") String login, Model model, HttpSession session) {
        User user = userService.getUser(login);
        if (user == null)
            return "user";
        model.addAttribute("user", user);
        model.addAttribute("title", String.format("Крауд-пользователь %s", user.getLogin()));
        model.addAttribute("currentUser", userService.isActiveUser(user, session));
        model.addAttribute("currentUserObj", userService.getActiveUser(session));

        //model.addAttribute("enterprises", enterpriseService.getAllFor(user));

        return "user";
    }

    @RequestMapping(value = "/user/{login}/ban", method = RequestMethod.GET)
    public String ban(@PathVariable("login") String login, Model model, HttpSession session) {
        User user = userService.getUser(login);
        if (user == null)
            return "redirect:/user/" + login;

        model.addAttribute("title", "Заблокировать пользователя");
        return "ban";
    }

    @RequestMapping(value = "/user/{login}/ban", method = RequestMethod.POST)
    public String doBan(@PathVariable("login") String login, Model model, HttpSession session,
                        BindingResult bindingResult) {
        User user = userService.getUser(login);
        if (user == null)
            return "redirect:/user/" + login;

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Заблокировать пользователя");
        }
        return "redirect:/user/" + login;
    }

    @RequestMapping(value = "/admin/createModer", method = RequestMethod.GET)
    public String createModer(Model model) {
        model.addAttribute("title", "Создать модератора");
        return "createModer";
    }

    @RequestMapping(value = "/admin/createModer", method = RequestMethod.POST)
    public String createModerPost(Model model, HttpSession httpSession,
                                  @Validated @ModelAttribute("userModel") User user, BindingResult bindingResult) {
        User activeUser = userService.getActiveUser(httpSession);//TODO ????
        registerService.registerUser(user);
        return "redirect:/user/" + user.getLogin();
    }
}
