package Test;

import org.junit.jupiter.api.Test;
import user_role_management.user_management.User;
import user_role_management.user_management.UserProfileManagement;
import static org.junit.jupiter.api.Assertions.*;

public class UserProfileManagementTest {

    @Test
    public void testCreateUser() {
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        userProfileManagement.createUser("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");

        User user = userProfileManagement.getUserProfile("leonardo_dicaprio");

        assertNotNull(user);
        assertEquals("leonardo_dicaprio", user.getUsername());
        assertEquals("Leonardo DiCaprio", user.getName());
        assertEquals("leo@dicaprio.com", user.getEmail());
    }

    @Test
    public void testGetUserProfile_NotFound() {
        UserProfileManagement userProfileManagement = new UserProfileManagement();

        User user = userProfileManagement.getUserProfile("non_existent_user");

        assertNull(user);
    }
}


