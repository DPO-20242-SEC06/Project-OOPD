package progress_feedback_system.feedback_system;

import lp_act_mg.learning_path.LearningPath;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Rating {
    private String learningPathId;
    private LearningPath lp;
    private double completionPercentage;
    private Date initDate;
    private Date finishDate;
    private Map<String, Integer> timeActivities;  
    private Map<String, Float> successRate;       
    private Map<String, Date> dateCompletion;     

    public Rating(String learningPathId, LearningPath lp, double completionPercentage, Date initDate, Date finishDate) {
        this.learningPathId = learningPathId;
        this.lp = lp;
        this.completionPercentage = completionPercentage;
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.timeActivities = new HashMap<>();
        this.successRate = new HashMap<>();
        this.dateCompletion = new HashMap<>();
    }

    public void addActivityTime(String activityId, int time) {
        timeActivities.put(activityId, time);
    }

    public void addActivitySuccessRate(String activityId, float rate) {
        successRate.put(activityId, rate);
    }

    public void addActivityCompletionDate(String activityId, Date completionDate) {
        dateCompletion.put(activityId, completionDate);
    }

    public String getLearningPathId() {
        return learningPathId;
    }

    public LearningPath getLearningPath() {
        return lp;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }

    public Date getInitDate() {
        return initDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Map<String, Integer> getTimeActivities() {
        return timeActivities;
    }

    public Map<String, Float> getSuccessRate() {
        return successRate;
    }

    public Map<String, Date> getDateCompletion() {
        return dateCompletion;
    }
}
