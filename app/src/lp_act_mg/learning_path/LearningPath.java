package lp_act_mg.learning_path;

import lp_act_mg.activity.Activity;

import java.util.*;

public class LearningPath {
    private String id;
    private String title;
    private String description;
    private String objectives;
    private String difficultyLevel;
    private List<Activity> activities;
    
    public LearningPath() {
        this.id = "";
        this.title = "";
        this.description = "";
        this.objectives = "";
        this.difficultyLevel = "";
    }

    public LearningPath(String id, String title, String description, String objectives, String difficultyLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.objectives = objectives;
        this.difficultyLevel = difficultyLevel;
        this.activities = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }
}


