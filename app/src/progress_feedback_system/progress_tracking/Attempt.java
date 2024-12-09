package progress_feedback_system.progress_tracking;

import java.util.Date;

public class Attempt {
    private int duration; 
    private boolean completed;
    private boolean approved;
    private boolean grade; 
    private String result;
    private Date finishDate;
    private Date initDate;

    public Attempt(int duration, boolean completed, boolean approved, boolean grade, String result, Date initDate, Date finishDate) {
        this.duration = duration;
        this.completed = completed;
        this.approved = approved;
        this.grade = grade;
        this.result = result;
        this.initDate = initDate;
        this.finishDate = finishDate;
    }

    
    public int getDuration() {
        return duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isGrade() {
        return grade;
    }

    public String getResult() {
        return result;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Date getInitDate() {
        return initDate;
    }
}

