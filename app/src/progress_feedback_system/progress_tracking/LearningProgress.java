package progress_feedback_system.progress_tracking;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LearningProgress {
    private String learningPathId;
    private double completionPercentage;
    private Date initDate;
    private Date finishDate;
    private Map<String, Float> successRate;       
    private Map<String, Integer> timeActivities; 
    private Map<String, Date> dateCompletion;    

    public LearningProgress(String learningPathId, Date initDate) {
        this.learningPathId = learningPathId;
        this.completionPercentage = 0.0;
        this.initDate = initDate;
        this.finishDate = null;
        this.successRate = new HashMap<>();
        this.timeActivities = new HashMap<>();
        this.dateCompletion = new HashMap<>();
    }

    public void updateCompletionPercentage(double percentage) {
        this.completionPercentage = Math.min(100.0, percentage); 
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void addActivityData(String activityId, float successRate, int time, Date completionDate) {
        this.successRate.put(activityId, successRate);
        this.timeActivities.put(activityId, time);
        this.dateCompletion.put(activityId, completionDate);
    }

    public String getLearningPathId() {
        return learningPathId;
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

    public Map<String, Float> getSuccessRate() {
        return successRate;
    }

    public Map<String, Integer> getTimeActivities() {
        return timeActivities;
    }

    public Map<String, Date> getDateCompletion() {
        return dateCompletion;
    }
}
