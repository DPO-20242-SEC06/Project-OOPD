package user_role_management.auth_service;

import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;
import user_role_management.user_management.User;

public class AuthenticationService {

    private UserProfileManagement userProfileManagement;
    private RoleManagement roleManagement;

    public AuthenticationService(RoleManagement roleManagement, UserProfileManagement userProfileManagement) {
        this.roleManagement = roleManagement;
        this.userProfileManagement = userProfileManagement;
    }

    public boolean login(String username, String password) {
        User user = userProfileManagement.getUserProfile(username);
        if (user != null && user.login(username, password)) {
            return true;
        }
        return false;
    }

    public boolean registerUser(String username, String password, String name, String email, String role) {
        if (userProfileManagement.getUserProfile(username) != null) {
            System.out.println("El usuario ya existe");
            return false;
        }

        userProfileManagement.createUser(username, password, name, email);
        roleManagement.assignRole(username, role);
        return true;
    }
}
