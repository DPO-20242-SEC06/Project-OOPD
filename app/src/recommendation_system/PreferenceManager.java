package recommendation_system;

import java.util.List;
import java.util.Map;

import lp_act_mg.activity.Activity;
import lp_act_mg.learning_path.LearningPath;
import user_role_management.user_management.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class PreferenceManager {
    private Map<String, List<String>> studentPreferences;

    public PreferenceManager() {
        this.studentPreferences = new HashMap<>();
    }

    public List<String> getStudentPreferences(String studentUser) {
        return studentPreferences.getOrDefault(studentUser, new ArrayList<>());
    }

    public List<Activity> recommendNextActivity(Student student, LearningPath lp) {
        List<Activity> activities = new ArrayList<>();
        List<Activity> learningPathActivities = lp.getActivities(); 
        List<String> preferences = getStudentPreferences(student.getUsername());

        for (Activity activity : learningPathActivities) {
            if (preferences.contains(activity.getRating())) { 
                activities.add(activity);
                break; 
            }
        }

        return activities;
    }


}