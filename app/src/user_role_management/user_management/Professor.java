package user_role_management.user_management;

public class Professor extends User {
    public static final String PROFESSOR = "Professor";
    private List<LearningPath> learningPaths;
    private List<Activity> activities

    public Professor(String username, String password, String name, String email) {
        super(username, password, name, email);
    }

    public void createLearningPath(LearningPath lp) {
        learningPaths.add(lp);
    }
    
    public void createActivity (Activity activity) {
    	activities.add(activity);
    }

    public void editLearningPath(LearningPath lp) {
        // lógica para editar LearningPath
    }
}
