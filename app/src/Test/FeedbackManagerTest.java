package Test;

import progress_feedback_system.feedback_system.FeedbackManager;
import progress_feedback_system.feedback_system.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

class FeedbackManagerTest {

    private FeedbackManager feedbackManager;

    @BeforeEach
    void setUp() {
        feedbackManager = new FeedbackManager();
    }

    @Test
    void testSubmitFeedback() {
        String studentId = "student1";
        String learningPathId = "LP001";
        Review review = feedbackManager.createReview("Great Learning Path!", 5, new Date());

        feedbackManager.submitFeedback(studentId, learningPathId, review);

        List<Review> reviews = feedbackManager.getFeedbackLP(learningPathId);
        assertNotNull(reviews);
        assertEquals(1, reviews.size());
        assertEquals("Great Learning Path!", reviews.get(0).getFeedback());
        assertEquals(5, reviews.get(0).getRating());
    }

    @Test
    void testGetAverageRatingLP() {
        String learningPathId = "LP001";
        Review review1 = feedbackManager.createReview("Good course", 4, new Date());
        Review review2 = feedbackManager.createReview("Excellent", 5, new Date());

        feedbackManager.submitFeedback("student1", learningPathId, review1);
        feedbackManager.submitFeedback("student2", learningPathId, review2);

        double averageRating = feedbackManager.getAverageRatingLP(learningPathId);
        assertEquals(4.5, averageRating, 0.1);
    }

    @Test
    void testGetAverageRatingAC() {
        String activityId = "Activity001";
        Review review1 = feedbackManager.createReview("Nice activity", 4, new Date());
        Review review2 = feedbackManager.createReview("Challenging", 3, new Date());

        feedbackManager.submitFeedback("student1", activityId, review1);
        feedbackManager.submitFeedback("student2", activityId, review2);

        double averageRating = feedbackManager.getAverageRatingAC(activityId);
        assertEquals(3.5, averageRating, 0.1);
    }

    @Test
    void testGetFeedbackLP() {
        String learningPathId = "LP001";
        Review review1 = feedbackManager.createReview("Great!", 5, new Date());
        Review review2 = feedbackManager.createReview("Needs improvement", 3, new Date());

        feedbackManager.submitFeedback("student1", learningPathId, review1);
        feedbackManager.submitFeedback("student2", learningPathId, review2);

        List<Review> reviews = feedbackManager.getFeedbackLP(learningPathId);
        assertNotNull(reviews);
        assertEquals(2, reviews.size());
        assertEquals("Great!", reviews.get(0).getFeedback());
        assertEquals("Needs improvement", reviews.get(1).getFeedback());
    }

    @Test
    void testGetFeedbackAC() {
        String activityId = "Activity001";
        Review review1 = feedbackManager.createReview("Interesting", 4, new Date());
        Review review2 = feedbackManager.createReview("Too easy", 2, new Date());

        feedbackManager.submitFeedback("student1", activityId, review1);
        feedbackManager.submitFeedback("student2", activityId, review2);

        List<Review> reviews = feedbackManager.getFeedbackAC(activityId);
        assertNotNull(reviews);
        assertEquals(2, reviews.size());
        assertEquals("Interesting", reviews.get(0).getFeedback());
        assertEquals("Too easy", reviews.get(1).getFeedback());
    }
}
