package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.password.Password;
import by.bsuir.db.password.PasswordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class LoginService {
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private PasswordDAO passwordDAO;
    @Autowired
    private AuthManager authManager;

    public boolean tryLogin(String login, String password, HttpSession httpSession)
    {
        Password passwordObj;
        boolean success = false;
        if ((passwordObj = passwordDAO.read(login, Password.class)) != null)
        {
            success = passwordObj.getPassword().equals(password);
            authManager.addNewAuth(login, httpSession);
        }
        return success;
    }

    public void logout(HttpSession httpSession)
    {
        authManager.removeAuth(httpSession);
    }
}
