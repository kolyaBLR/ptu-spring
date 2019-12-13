package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class IndexPageService {
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private AuthManager authManager;

    public List<BaseUser> allUsers()
    {
        return baseUserDAO.readAll(BaseUser.class);
    }

    public BaseUser getCurrentUser(HttpSession httpSession)
    {
        String login = authManager.checkAuth(httpSession);
        if (login == null)
            return null;
        return baseUserDAO.read(login, BaseUser.class);
    }
}
