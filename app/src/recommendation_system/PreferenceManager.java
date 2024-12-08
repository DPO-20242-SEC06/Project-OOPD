package recommendation_system;

import lp_act_mg.activity.Activity;
import lp_act_mg.activity.ActivityManager;
import lp_act_mg.learning_path.LearningPath;
import user_role_management.user_management.Student;

import java.util.ArrayList;
import java.util.List;

public class PreferenceManager {
    private ActivityManager activityManager;

    public PreferenceManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    public List<String> getStudentPreferences(String studentUser) {
        return new ArrayList<>();
    }

    public List<Activity> recommendNextActivity(Student student, LearningPath lp) {
        List<Activity> activities = new ArrayList<>();
        List<Activity> learningPathActivities = activityManager.activities; 

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