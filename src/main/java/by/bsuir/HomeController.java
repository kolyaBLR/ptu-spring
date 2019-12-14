package by.bsuir;

import by.bsuir.db.company.Company;
import by.bsuir.db.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String empty() {
        return "redirect:/home";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    String home(Model model, HttpSession session) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", activeUser);
        model.addAttribute("companies", companyService.findAll(activeUser.getLogin()));
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    String deleteCompany(Model model, HttpSession session, Company companyModel) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        companyService.delete(companyModel.getId());
        return "redirect:/home";
    }
}
