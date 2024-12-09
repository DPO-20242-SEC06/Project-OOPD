package Test;

import org.junit.jupiter.api.Test;

import user_role_management.user_management.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testLogin_Success() {
        User user = new User("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");

        boolean result = user.login("leonardo_dicaprio", "password123");

        assertTrue(result);
    }

    @Test
    public void testLogin_Failure_WrongPassword() {
        User user = new User("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");

        boolean result = user.login("leonardo_dicaprio", "wrong_password");

        assertFalse(result);
    }

    @Test
    public void testLogin_Failure_WrongUsername() {
        User user = new User("leonardo_dicaprio", "password123", "Leonardo DiCaprio", "leo@dicaprio.com");

        boolean result = user.login("wrong_username", "password123");

        assertFalse(result);
    }
}

