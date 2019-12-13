package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPageController {
    @Autowired
    private IndexPageService indexPageService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("users", indexPageService.allUsers());
        model.addAttribute("title", "Крауд-проекты для всех и везде!");
        model.addAttribute("currentUser", indexPageService.getCurrentUser(session));
        model.addAttribute("topProjects", projectService.getTop());
        return "index";
    }
}
