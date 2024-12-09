package Test;
import org.junit.jupiter.api.Test;

import user_role_management.role_management.RoleManagement;

import static org.junit.jupiter.api.Assertions.*;

public class RoleManagementTest {

    @Test
    public void testAssignRole() {
        RoleManagement roleManagement = new RoleManagement();

        roleManagement.assignRole("leonardo_dicaprio", "Profesor");

        assertEquals("Profesor", roleManagement.getUserRole("leonardo_dicaprio"));
    }

    @Test
    public void testGetUserRole_NotAssigned() {
        RoleManagement roleManagement = new RoleManagement();

        String role = roleManagement.getUserRole("non_existent_user");

        assertNull(role);
    }

    @Test
    public void testAssignMultipleRoles() {
        RoleManagement roleManagement = new RoleManagement();

        roleManagement.assignRole("selenagomez", "Estudiante");
        roleManagement.assignRole("morganfreeman", "Profesor");

        assertEquals("Estudiante", roleManagement.getUserRole("selenagomez"));
        assertEquals("Profesor", roleManagement.getUserRole("morganfreeman"));
    }
}

