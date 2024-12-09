package user_role_management.role_management;

import java.util.HashMap;
import java.util.Map;

public class RoleManagement {
    private Map<String, String> roles = new HashMap<>();

    public String getUserRole(String username) {
        return roles.get(username);
    }

    public void assignRole(String username, String role) {
        roles.put(username, role);
    }
}
