package by.bsuir.auth;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AuthManagerImpl implements AuthManager {

    private Map<String, String> authMap = new HashMap<>();

    @Override
    public void addNewAuth(String login, HttpSession httpSession) {
        authMap.put(genKey(login), login);
        httpSession.setAttribute("auth-key", genKey(login));
    }

    @Override
    public void removeAuth(HttpSession httpSession) {
        String key = (String) httpSession.getAttribute("auth-key");
        if (key == null)
            return;
        authMap.remove(key);
        httpSession.removeAttribute("auth-key");
    }

    @Override
    public String checkAuth(String key) {
        return authMap.get(key);
    }

    @Override
    public String checkAuth(HttpSession session) {
        return checkAuth((String) session.getAttribute("auth-key"));
    }

    private String genKey(String login)
    {
        return "auth-key-" + login;
    }
}
