package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.user.User;
import by.bsuir.db.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthManager authManager;

    public boolean tryLogin(String login, String password, HttpSession httpSession) {
        User user = userRepository.read(login, User.class);
        if (user != null) {
            boolean isSuccess = user.getLogin().equals(login)
                    && user.getPassword().equals(password);
            if (isSuccess) {
                authManager.addNewAuth(login, httpSession);
                return true;
            }
        }
        return false;
    }

    public void logout(HttpSession httpSession) {
        authManager.removeAuth(httpSession);
    }
}
