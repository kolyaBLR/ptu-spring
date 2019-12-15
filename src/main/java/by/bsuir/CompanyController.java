package by.bsuir;

import by.bsuir.db.company.Company;
import by.bsuir.db.user.User;
import by.bsuir.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.servlet.http.HttpSession;

@RequestMapping("/company")
@Controller
public class CompanyController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ConversionService conversionService;

    @InitBinder(value = "companyModel")
    public void userModelBinder(WebDataBinder binder) {
        binder.setConversionService(conversionService);
        binder.addValidators(CompanyService.getCompanyValidator());
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    String showCompany(Model model, HttpSession session) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("companyModel", new CompanyModel());
        model.addAttribute("action_name", "Добавить");
        return "company";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String saveCompany(@Validated @ModelAttribute("companyModel") CompanyModel company,
                       BindingResult result, HttpSession session, Model model) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        if (!result.hasErrors()) {
            companyService.insertOrUpdate(company, activeUser.getLogin());
            model.addAttribute("companyModel", company);
            model.addAttribute("action_name", "Обновить");
        } else {
            model.addAttribute("companyModel", company);
            model.addAttribute("action_name", "Добавить");
        }
        return "company";
    }
}
