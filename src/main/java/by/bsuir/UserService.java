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
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthManager authManager;

    public User getUser(String login) {
        return userRepository.read(login, User.class);
    }

    public boolean isActiveUser(User baseUser, HttpSession httpSession) {
        return baseUser.getLogin().equals(authManager.checkAuth(httpSession));
    }

    public User getActiveUser(HttpSession httpSession) {
        return getUser(authManager.checkAuth(httpSession));
    }
}
