package user_role_management.user_management;

import java.util.HashMap;
import java.util.Map;

public class UserProfileManagement {
    private Map<String, User> users = new HashMap<>();

    // Obtener el perfil de usuario por username
    public User getUserProfile(String username) {
        return users.get(username);
    }

    // Crear un nuevo usuario
    public void createUser(String username, String name, String email, String password) {
        if (users.containsKey(username)) {
            System.out.println("El usuario ya existe: " + username);
            return;
        }
        // Crear un usuario genérico o especializado según el caso
        users.put(username, new User(username, password, name, email) {});
        System.out.println("Usuario creado: " + username);
    }

    // Actualizar el perfil de usuario
    public void updateUserProfile(String username, String newName, String newEmail) {
        User user = users.get(username);
        if (user != null) {
            user.name = newName;
            user.email = newEmail;
            System.out.println("Perfil actualizado para: " + username);
        } else {
            System.out.println("Usuario no encontrado: " + username);
        }
    }
}
