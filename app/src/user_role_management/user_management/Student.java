package user_role_management.user_management;

public class Student extends User {
    public static final String STUDENT = "Student";
    private String preferences;
    private List<LearningProgress> currentProgresses;
    private List<LearningProgress> completed;
    private List<Attempt> attempts;

    public Student(String username, String password, String name, String email) {
        super(username, password, name, email);
    }

    public void enrollLearningPath(LearningPath lp) {
        currentProgresses.add(new LearningProgress(lp));
    }

    public void completeActivity(Activity activity) {
        // lógica para completar una actividad
    }

    public LearningProgress viewLearningProgress(LearningPath lp) {
        // lógica para ver el progreso de aprendizaje
        return null;
    }
}
