package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.baseuser.BaseUserType;
import by.bsuir.db.project.Project;
import by.bsuir.db.project.ProjectDAO;
import by.bsuir.db.projecttop.ProjectTop;
import by.bsuir.db.projecttop.ProjectTopDAO;
import by.bsuir.db.taggeditem.TaggedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private ProjectTopDAO projectTopDAO;

    public Project getProject(Integer id)
    {
        return projectDAO.read(id, Project.class);
    }

    public List<Project> getAll()
    {
        return projectDAO.readAll(Project.class);
    }

    public boolean canCreateProject(HttpSession httpSession)
    {
        String login = authManager.checkAuth(httpSession);
        return login != null && baseUserDAO.read(login, BaseUser.class).getType().equals(BaseUserType.user.value);
    }

    public void createProject(Project project, HttpSession httpSession)
    {
        String userLogin = authManager.checkAuth(httpSession);
        project.setCreationDate(new Timestamp(System.currentTimeMillis()));
        project.setTaggedItem(new TaggedItem());
        project.setCreator(baseUserDAO.read(userLogin, BaseUser.class));
        projectDAO.create(project);
    }

    public void setPlace(Project project, Integer place)
    {
        ProjectTop projectTop = projectTopDAO.read(place, ProjectTop.class);
        if (projectTop == null) {
            projectTop = new ProjectTop();
            projectTop.setPlace(place);
            projectTop.setProject(project);
            projectTopDAO.create(projectTop);
            return;
        }
        projectTop.setProject(project);
        projectTopDAO.update(projectTop);
    }

    public List<Project> getTop()
    {
        List<ProjectTop> projectTopList = projectTopDAO.readAll(ProjectTop.class);
        List<Project> result = new ArrayList<>();
        for (ProjectTop projectTop : projectTopList)
            result.add(projectTop.getProject());
        return result;
    }

    public void deleteAllCreatedBy(BaseUser baseUser)
    {
        List<ProjectTop> projectTopList = projectTopDAO.readAll(ProjectTop.class);
        List<Project> projects = projectDAO.getAllCreatedBy(baseUser);
        for (Project project : projects)
        {
            for (ProjectTop projectTop : projectTopList)
            {
                if (projectTop.getProject().equals(project))
                    projectTopDAO.delete(projectTop.getPlace(), ProjectTop.class);
            }
            projectDAO.delete(project.getId(), Project.class);
        }
    }

    public void updateProject(Project project)
    {
        projectDAO.update(project);
    }
}
