/*
package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserType;
import by.bsuir.db.project.Project;
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
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    UserService userService;

    @InitBinder(value = "projectModel")
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return Project.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "namedItem.name", "field.empty");
                Project project = (Project) o;
                if (project.getNamedItem().getName().length() > 32)
                    errors.rejectValue("namedItem.name", "field.max32");
            }
        });
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String allProjects(Model model)
    {
        model.addAttribute("projects", projectService.getAll());
        model.addAttribute("title", "Список крауд-проектов");
        return "projects/projects";
    }

    @RequestMapping(value = "/projects/create", method = RequestMethod.GET)
    public String createProject(Model model, HttpSession session)
    {
        if (projectService.canCreateProject(session))
        {
            model.addAttribute("projectModel", new Project());
            model.addAttribute("title", "Создать новый крауд-проект");
            return "projects/create";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/projects/create", method = RequestMethod.POST)
    public String doCreateProject(@Validated @ModelAttribute("projectModel") Project project, BindingResult bindingResult,
                                  Model model, HttpSession session)
    {
        if (projectService.canCreateProject(session) && !bindingResult.hasErrors())
        {
            projectService.createProject(project, session);
            return "redirect:/project/" + project.getId();
        } else if (bindingResult.hasErrors()) {
            model.addAttribute("projectModel", project);
            model.addAttribute("title", "Создать новый крауд-проект");
            return "projects/create";
        } else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public String project(@PathVariable("id") Integer id, Model model, HttpSession httpSession)
    {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        model.addAttribute("title", String.format("Крауд-проект %s", project.getNamedItem().getName()));
        model.addAttribute("currentUser", userService.getActiveUser(httpSession));
        return "projects/project";
    }

    @RequestMapping(value = "/project/{id}/place/{place}", method = RequestMethod.GET)
    public String place(@PathVariable("id") Integer id, @PathVariable("place") Integer place,
                        Model model, HttpSession httpSession)
    {
        BaseUser baseUser = userService.getActiveUser(httpSession);
        Project project = projectService.getProject(id);
        if (baseUser == null || !baseUser.getType().equals(BaseUserType.admin.value))
            return "redirect:/login";
        projectService.setPlace(project, place);
        return "redirect:/project/" + id;
    }

    @RequestMapping(value = "/project/{id}/follow", method = RequestMethod.GET)
    public String follow(@PathVariable("id") Integer id, HttpSession httpSession)
    {
        BaseUser activeUser = userService.getActiveUser(httpSession);
        if (activeUser == null)
            return "redirect:/login";
        Project project = projectService.getProject(id);
        project.getFollowers().add(activeUser);
        projectService.updateProject(project);
        return "redirect:/project/" + project.getId();
    }

    @RequestMapping(value = "/project/{id}/unfollow", method = RequestMethod.GET)
    public String unfollow(@PathVariable("id") Integer id, HttpSession httpSession)
    {
        BaseUser activeUser = userService.getActiveUser(httpSession);
        if (activeUser == null)
            return "redirect:/login";
        Project project = projectService.getProject(id);
        project.getFollowers().remove(activeUser);
        projectService.updateProject(project);
        return "redirect:/project/" + project.getId();
    }
}
*/
