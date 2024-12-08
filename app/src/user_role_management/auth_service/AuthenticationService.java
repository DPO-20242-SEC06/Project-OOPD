
package user_role_management.auth_service;

import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.User;
import user_role_management.user_management.UserProfileManagement;

public class AuthenticationService {
    private RoleManagement roleManagement;
    private UserProfileManagement userManagement;

    // Constructor
    public AuthenticationService(RoleManagement roleManagement, UserProfileManagement userManagement) {
        this.roleManagement = roleManagement;
        this.userManagement = userManagement;
    }

    // Método para validar credenciales de usuario
    public boolean validate(String username, String password) {
        User user = userManagement.getUserProfile(username); // Obtener el perfil del usuario
        if (user == null) {
            System.out.println("Usuario no encontrado");
            return false;
        }
        return user.login(username, password); // Verificar login
    }

    // Método para registrar un nuevo usuario
    public boolean registerUser(String username, String name, String email, String password, String role) {
        if (userManagement.getUserProfile(username) != null) {
            System.out.println("El usuario ya existe");
            return false;
        }

        // Crear el nuevo usuario en el sistema
        userManagement.createUser(username, name, email, password);
        
        // Asignar un rol al usuario
        roleManagement.assignRole(username, role);
        return true;
    }
}
