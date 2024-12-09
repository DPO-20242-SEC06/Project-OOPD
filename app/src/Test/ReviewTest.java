package Test;
import progress_feedback_system.feedback_system.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class ReviewTest {

    private Review review;

    @BeforeEach
    void setUp() {
        review = new Review("Great course!", 5, new Date());
    }

    @Test
    void testGetFeedback() {
        assertEquals("Great course!", review.getFeedback());
    }

    @Test
    void testGetRating() {
        assertEquals(5, review.getRating());
    }

    @Test
    void testGetDate() {
        assertNotNull(review.getDate());
    }
}
