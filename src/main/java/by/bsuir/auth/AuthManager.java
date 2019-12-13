package by.bsuir.auth;

import javax.servlet.http.HttpSession;

public interface AuthManager {
    void addNewAuth(String login, HttpSession httpSession);
    void removeAuth(HttpSession httpSession);
    String checkAuth(String key);
    String checkAuth(HttpSession session);
}
