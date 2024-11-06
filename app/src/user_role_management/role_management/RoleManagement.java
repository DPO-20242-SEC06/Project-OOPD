package user_role_management.role_management;

public class RoleManagement {
    private Map<String, String> roles = new HashMap<>();

    public String getUserRole(String username) {
        return roles.get(username);
    }

    public void assignRole(User user, String role) {
        roles.put(user.username, role);
    }
}
