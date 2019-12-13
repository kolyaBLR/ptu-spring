package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserType;
import by.bsuir.db.enterprise.Enterprise;
import by.bsuir.db.enterpriseproduct.EnterpriseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @InitBinder(value = "enterpriseModel")
    protected void initBinder(WebDataBinder webDataBinder)
    {
        webDataBinder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return Enterprise.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "namedItem.name", "field.empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationId", "field.empty");

                Enterprise enterprise = (Enterprise) o;
                if (enterprise.getNamedItem().getName().length() > 32)
                    errors.rejectValue("namedItem.name", "field.max32");
                if (enterprise.getRegistrationId().length() > 32)
                    errors.rejectValue("registrationId", "field.max32");
            }
        });
    }

    @InitBinder(value = "interpriseProductModel")
    protected void initAnotherBinder(WebDataBinder webDataBinder)
    {
        webDataBinder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return EnterpriseProduct.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                EnterpriseProduct enterpriseProduct = (EnterpriseProduct) o;
                if (enterpriseProduct.getAmount() < 0)
                    errors.rejectValue("amount", "field.nonnegative");
                if (enterpriseProduct.getCost() < 0)
                    errors.rejectValue("amount", "field.nonnegative");
            }
        });
    }

    @RequestMapping(value = "/enterprises", method = RequestMethod.GET)
    public String enterprises(Model model)
    {
        model.addAttribute("title", "Предприятия");
        model.addAttribute("enterprises", enterpriseService.getAll());
        return "enterprise/enterprises";
    }

    @RequestMapping(value = "/enterprise/{regId}", method = RequestMethod.GET)
    public String enterprise(@PathVariable("regId") String regId, Model model, HttpSession httpSession)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(regId);
        if (enterprise == null)
            return "enterprise/enterprise";
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("enterpriseProducts", productService.getEnterpriseProductsFor(enterprise));
        model.addAttribute("currentUser", userService.getActiveUser(httpSession));
        model.addAttribute("title", "Предприятие " + enterprise.getNamedItem().getName());
        return "enterprise/enterprise";
    }

    @RequestMapping(value = "/enterprise/{regId}/approve", method = RequestMethod.GET)
    public String approve(@PathVariable("regId") String regId, Model model, HttpSession httpSession)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(regId);
        if (enterprise == null)
            return "redirect:/enterprise/enterprise";
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.getType().equals(BaseUserType.moderator.value))
            return "redirect:/login";
        if (enterprise.getApprovedBy() == null)
        {
            enterprise.setApprovedBy(baseUser);
            enterpriseService.updateEnterprise(enterprise);
        }
        return "redirect:/user/" + baseUser.getLogin();
    }

    @RequestMapping(value = "/enterprise/{regId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("regId") String regId, Model model, HttpSession httpSession)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(regId);
        if (enterprise == null)
            return "redirect:/enterprise/enterprise";
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.getType().equals(BaseUserType.moderator.value))
            return "redirect:/login";
        enterpriseService.deleteEnterprise(enterprise);
        return "redirect:/user/" + baseUser.getLogin();
    }

    @RequestMapping(value = "/enterprise/{regId}/addProduct", method = RequestMethod.GET)
    public String addProduct(@PathVariable("regId") String regId, Model model, HttpSession httpSession)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(regId);
        if (enterprise == null)
            return "redirect:/enterprise/enterprise";
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.equals(enterprise.getOwner()))
            return "redirect:/login";

        model.addAttribute("enterpriseProductModel", new EnterpriseProduct());
        model.addAttribute("products", productService.getAll());
        return "products/addProduct";
    }

    @RequestMapping(value = "/enterprise/{regId}/addProduct", method = RequestMethod.POST)
    public String addProductPost(@PathVariable("regId") String regId, Model model, HttpSession httpSession,
                                 @ModelAttribute("enterpriseProductModel") EnterpriseProduct enterpriseProduct,
                                 BindingResult bindingResult)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(regId);
        if (enterprise == null)
            return "redirect:/enterprise/enterprise";
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.equals(enterprise.getOwner()))
            return "redirect:/login";
        if (bindingResult.hasErrors()) {

            model.addAttribute("products", productService.getAll());
            model.addAttribute("enterpriseProductModel", enterprise);
            return "products/addProduct";
        } else {
            productService.addEnterpriseProduct(enterpriseProduct, enterprise);
        }
        return "redirect:/enterprise/" + enterprise.getRegistrationId();
    }

    @RequestMapping(value = "/enterprise/create", method = RequestMethod.GET)
    public String createEnterprise(Model model, HttpSession httpSession)
    {
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.getType().equals(BaseUserType.enterpreneur.value))
            return "redirect:/login";
        model.addAttribute("title", "Добавить предприятие");
        model.addAttribute("enterpriseModel", new Enterprise());
        return "enterprise/create";
    }

    @RequestMapping(value = "/enterprise/create", method = RequestMethod.POST)
    public String createEnterprisePost(Model model, HttpSession httpSession,
                                       @Validated @ModelAttribute("enterpriseModel") Enterprise enterprise,
                                       BindingResult bindingResult)
    {
        BaseUser baseUser = userService.getActiveUser(httpSession);
        if (baseUser == null || !baseUser.getType().equals(BaseUserType.enterpreneur.value))
            return "redirect:/login";
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Добавить предприятие");
            model.addAttribute("enterpriseModel", enterprise);
            return "enterprise/create";
        } else {
            enterpriseService.createEnterprise(enterprise, baseUser);
            return "redirect:/enterprise/" + enterprise.getRegistrationId();
        }
    }
}
