public static void main(String[] args) {
    UserProfileManagement userProfileManagement = new UserProfileManagement();

    // Crear usuarios
    userProfileManagement.createUser("prof01", "Dr. Smith", "smith@school.edu", "password123");
    userProfileManagement.createUser("stud01", "John Doe", "john@student.com", "password456");

    // Obtener perfil
    User user = userProfileManagement.getUserProfile("prof01");
    if (user != null) {
        System.out.println("Usuario encontrado: " + user.getName());
    }

    // Actualizar perfil
    userProfileManagement.updateUserProfile("stud01", "John A. Doe", "john.doe@student.com");
}
