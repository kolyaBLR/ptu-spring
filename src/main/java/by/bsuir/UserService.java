package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.ban.Ban;
import by.bsuir.db.ban.BanDAO;
import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.baseuser.BaseUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserService {
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private BanDAO banDAO;
    @Autowired
    private ProjectService projectService;

    public BaseUser getUser(String login)
    {
        return baseUserDAO.read(login, BaseUser.class);
    }

    public boolean isActiveUser(BaseUser baseUser, HttpSession httpSession)
    {
        return baseUser.getLogin().equals(authManager.checkAuth(httpSession));
    }

    public BaseUser getActiveUser(HttpSession httpSession)
    {
        return getUser(authManager.checkAuth(httpSession));
    }

    public Ban getBan(BaseUser baseUser)
    {
         return banDAO.read(baseUser.getLogin(), Ban.class);
    }

    public boolean tryToBan(BaseUser baseUser, String reason, HttpSession httpSession)
    {
        BaseUser activeUser = getActiveUser(httpSession);
        if (activeUser == null || baseUser == null)
            return false;
        if (getBan(baseUser) != null)
            return false;
        if (!baseUser.getType().equals(BaseUserType.admin.value)
                && (activeUser.getType().equals(BaseUserType.admin.value) || activeUser.getType().equals(BaseUserType.moderator.value)))
        {
            Ban ban = new Ban();
            ban.setUserLogin(baseUser.getLogin());
            ban.setUser(baseUser);
            ban.setReason(reason);
            banDAO.create(ban);

            projectService.deleteAllCreatedBy(baseUser);
            return true;
        }
        return false;
    }
}
