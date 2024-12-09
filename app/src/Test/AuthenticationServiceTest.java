package Test;

import org.junit.jupiter.api.Test;

import user_role_management.auth_service.AuthenticationService;
import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {

    @Test
    public void testLogin_Success() {
        RoleManagement roleManagement = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManagement, userProfileManagement);

        userProfileManagement.createUser("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");
        roleManagement.assignRole("leonardo_dicaprio", "Profesor");

        boolean result = authService.login("leonardo_dicaprio", "password123");

        assertTrue(result);
    }

    @Test
    public void testLogin_Failure_InvalidPassword() {
        RoleManagement roleManagement = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManagement, userProfileManagement);

        userProfileManagement.createUser("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");
        roleManagement.assignRole("leonardo_dicaprio", "Profesor");

        boolean result = authService.login("leonardo_dicaprio", "wrong_password");

        assertFalse(result);
    }

    @Test
    public void testLogin_Failure_UserNotFound() {
        RoleManagement roleManagement = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManagement, userProfileManagement);

        boolean result = authService.login("non_existent_user", "password123");

        assertFalse(result);
    }

    @Test
    public void testRegisterUser_Success() {
        RoleManagement roleManagement = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManagement, userProfileManagement);

        boolean result = authService.registerUser("selenagomez", "password123", "Selena Gomez", "selena@gomez.com", "Estudiante");

        assertTrue(result);
        assertNotNull(userProfileManagement.getUserProfile("selenagomez"));
        assertEquals("Estudiante", roleManagement.getUserRole("selenagomez"));
    }

    @Test
    public void testRegisterUser_Failure_UserAlreadyExists() {
        RoleManagement roleManagement = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManagement, userProfileManagement);

        userProfileManagement.createUser("selenagomez", "password123", "Selena Gomez", "selena@gomez.com");
        roleManagement.assignRole("selenagomez", "Estudiante");

        boolean result = authService.registerUser("selenagomez", "newpassword123", "Selena Gomez", "selena@gomez.com", "Estudiante");

        assertFalse(result);
    }
}

