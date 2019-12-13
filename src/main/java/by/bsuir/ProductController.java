package by.bsuir;

import by.bsuir.db.product.Product;
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
public class ProductController {
    @Autowired
    private ProductService productService;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return Product.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "namedItem.name", "field.empty");
            }
        });
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String allProjects(Model model)
    {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("title", "Список продуктов");
        return "products/products";
    }

    @RequestMapping(value = "/products/create", method = RequestMethod.GET)
    public String createProject(Model model, HttpSession session)
    {
        if (productService.canCreateProduct(session))
        {
            model.addAttribute("productModel", new Product());
            model.addAttribute("title", "Создать новый продукт");
            return "products/create";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/products/create", method = RequestMethod.POST)
    public String doCreateProject(@Validated @ModelAttribute("productModel") Product product, BindingResult bindingResult,
                                  Model model, HttpSession session)
    {
        if (productService.canCreateProduct(session) && !bindingResult.hasErrors())
        {
            productService.createProduct(product, session);
            return "redirect:/product/" + product.getProductId();
        } else if (bindingResult.hasErrors()) {
            model.addAttribute("productModel", product);
            model.addAttribute("title", "Создать новый продукт");
            return "products/create";
        } else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String project(@PathVariable("id") Integer id, Model model)
    {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("title", String.format("Продукт %s", product.getNamedItem().getName()));
        return "products/product";
    }
}
