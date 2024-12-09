package progress_feedback_system.feedback_system;

import java.util.Date;

public class Review {
    private String feedback;
    private int rating;
    private Date date;

    public Review(String feedback, int rating, Date date) {
        this.feedback = feedback;
        this.rating = rating;
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }
}
