package user_role_management.user_management;

import java.util.HashMap;
import java.util.Map;

public class UserProfileManagement {
    private Map<String, User> users;

    public UserProfileManagement() {
        users = new HashMap<>();
    }

    public User getUserProfile(String username) {
        return users.get(username);
    }

    public void createUser(String username, String password, String name, String email) {
        User newUser = new User(username, password, name, email);
        users.put(username, newUser);
    }
    
    
}
