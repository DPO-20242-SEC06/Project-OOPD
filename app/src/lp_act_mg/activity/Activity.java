package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;
import lp_act_mg.learning_path.LearningPath;
import user_role_management.user_management.Student;

public abstract class Activity {

    protected  List<Activity> previousActivities;
    protected  List<Activity> followingActivities;
    protected  LearningPath learningPath;

    protected String id;
    protected String title;
    protected String description;
    protected String difficultyLevel; 
    protected int expectedDuration;
    protected String result;
    protected boolean mandatory;
    protected double  rating;
    
    protected Activity(String id, String title , String description, String difficultyLevel, int expectedDuration, boolean mandatory){
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.expectedDuration = expectedDuration;
        this.mandatory = mandatory;
        this.previousActivities = new ArrayList<>();
        this.followingActivities = new ArrayList<>();

    }

    public abstract  boolean isCompleted(Student student);

    public void addPreviousActivity(Activity activity){
        this.previousActivities.add(activity);
    }

    public void addFollowingActivity(Activity activity){
        this.followingActivities.add(activity);
    }

    public void setLearningPath(LearningPath learningPath){
        this.learningPath = learningPath;
    }

    public abstract void showActivity();

    


}