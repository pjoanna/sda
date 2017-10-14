package sda.spring.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoggedUsers {
    private Map<String, User> loggedUsers = new HashMap<>();

    public Map<String, User> getLoggedUsers() {
        return loggedUsers;
    }

    public void setLoggedUsers(Map<String, User> loggedUsers) {
        this.loggedUsers = loggedUsers;
    }
}
