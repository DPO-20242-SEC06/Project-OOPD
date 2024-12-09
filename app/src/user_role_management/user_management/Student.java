package user_role_management.user_management;

public class Student extends User {
    public static final String STUDENT = "Student";
    private String preferences;

    public Student(String username, String password, String name, String email, String preferences) {
        super(username, password, name, email);
        this.preferences = preferences;
    }

    public void enrollLearningPath(String learningPathName) {
        System.out.println("Inscrito en la ruta de aprendizaje: " + learningPathName);
    }

    public void completeActivity(String activityName) {
        System.out.println("Actividad completada: " + activityName);
    }
}
