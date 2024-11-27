package recommendation_system;

import java.util.List;

import lp_act_mg.activity.Activity;
import lp_act_mg.learning_path.LearningPath;
import user_role_management.user_management.Student;

import java.util.ArrayList;

public class RecommendationService {
    private PreferenceManager preferenceManager;

    public RecommendationService() {
        this.preferenceManager = new PreferenceManager();
    }

    public List<LearningPath> recommendLearningPath(Student student) {
        List<String> preferences = preferenceManager.getStudentPreferences(student.getUsername());
        List<LearningPath> learningPaths = new ArrayList<>();

        for (String preference : preferences) {
            learningPaths.add(new LearningPath(preference));
        }

        return learningPaths;
    }

    public List<Activity> recommendNextActivity(Student student, LearningPath lp) {
        return preferenceManager.recommendNextActivity(student, lp);
    }
}
