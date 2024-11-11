package lp_act_mg.activity;

import java.util.Date;
import java.util.List;

public class ActivityManager {

    // A list with all the activities that the system has available
    private List<Activity> activities;

    public ActivityManager(List<Activity> activities) {
        this.activities = activities;
    }

    public createActivity(String description, String difficultyLevel, int expectedDuration, Date limitDate, boolean mandatory) {
        // Create a new activity
        Activity activity = new Activity(description, difficultyLevel, expectedDuration, limitDate, mandatory);
        // Add the activity to the list of activities
        activities.add(activity);
    }


}
