package user_role_management.user_management;

public class Professor extends User {
    public static final String PROFESSOR = "Professor";

    public Professor(String username, String password, String name, String email) {
        super(username, password, name, email);
    }

    public void createLearningPath(String learningPathName) {
        System.out.println("Ruta de aprendizaje creada: " + learningPathName);
    }

    public void editLearningPath(String learningPathName) {
        System.out.println("Ruta de aprendizaje editada: " + learningPathName);
    }
}
