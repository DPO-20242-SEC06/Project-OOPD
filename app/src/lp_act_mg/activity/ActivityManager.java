package lp_act_mg.activity;

import java.util.*;

public class ActivityManager {
    public List<Activity> activities;

    public ActivityManager() {
        this.activities = new ArrayList<>();
    }

    public void createActivity(String description, String difficultyLevel, int expectedDuration, Date limitDate, boolean mandatory) {
        String id = UUID.randomUUID().toString();
        Activity activity = new ConcreteActivity(id, description, difficultyLevel, expectedDuration, limitDate, mandatory);
        this.activities.add(activity);
        System.out.println("Activity created: " + description);
    }

    public List<Activity> listAllActivities() {
        return this.activities;
    }

    public Activity getActivityById(String activityId) {
        for (Activity activity : this.activities) {
            if (activity.getId().equals(activityId)) {
                return activity;
            }
        }
        return null;
    }

    public void assignActivity(String learningPathId, String activityId) {
        for (Activity activity : this.activities) {
            if (activity.getId().equals(activityId)) {
                System.out.println("Activity assigned to learning path.");
                return;
            }
        }
        System.out.println("Activity not found.");
    }
}


