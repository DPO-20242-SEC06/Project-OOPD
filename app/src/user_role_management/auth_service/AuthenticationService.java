package user_role_management.auth_service;

public class AuthenticationService {
    private RoleManagement roleManagement;
    private UserProfileManagement userManagement;

    public boolean validate(String username, String password) {
        User user = userManagement.getUserProfile(username);
        return user != null && user.login(username, password);
    }

    public boolean registerUser(UserProfileManagement userProfileManagement) {
        // lógica para registrar usuario
        return true;
    }
}
