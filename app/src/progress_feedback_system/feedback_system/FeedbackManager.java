package progress_feedback_system.feedback_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackManager {

    private Map<String, List<Review>> activityFeedbacks = new HashMap<>();
    private Map<String, List<Review>> learningPathFeedbacks = new HashMap<>();

    public double getAverageRatingAC(String activityId) {
        List<Review> reviews = activityFeedbacks.getOrDefault(activityId, new ArrayList<>());
        if (reviews.isEmpty()) return 0;
        return reviews.stream().mapToInt(Review::getRating).average().orElse(0);
    }

    public List<Review> getFeedbackAC(String activityId) {
        return activityFeedbacks.getOrDefault(activityId, new ArrayList<>());
    }

    public double getAverageRatingLP(String learningPathId) {
        List<Review> reviews = learningPathFeedbacks.getOrDefault(learningPathId, new ArrayList<>());
        if (reviews.isEmpty()) return 0;
        return reviews.stream().mapToInt(Review::getRating).average().orElse(0);
    }

    public List<Review> getFeedbackLP(String learningPathId) {
        return learningPathFeedbacks.getOrDefault(learningPathId, new ArrayList<>());
    }

    public void submitFeedback(String studentId, String learningPathId, Review feedback) {
        learningPathFeedbacks.computeIfAbsent(learningPathId, k -> new ArrayList<>()).add(feedback);
    }

    public Review createReview(String feedback, int rating, Date date) {
        return new Review(feedback, rating, date);
    }
}

