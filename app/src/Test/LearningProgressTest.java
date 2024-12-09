package Test;

import progress_feedback_system.progress_tracking.LearningProgress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LearningProgressTest {

    private LearningProgress learningProgress;
    private Date now;

    @BeforeEach
    void setUp() {
        now = new Date();
        learningProgress = new LearningProgress("LP001", now);
    }

    @Test
    void testGetLearningPathId() {
        assertEquals("LP001", learningProgress.getLearningPathId());
    }

    @Test
    void testGetCompletionPercentage() {
        assertEquals(0.0, learningProgress.getCompletionPercentage());
    }

    @Test
    void testUpdateCompletionPercentage() {
        learningProgress.updateCompletionPercentage(50.0);
        assertEquals(50.0, learningProgress.getCompletionPercentage());
    }

    @Test
    void testAddActivityData() {
        learningProgress.addActivityData("ACT001", 0.8f, 30, now);
        Map<String, Float> successRate = learningProgress.getSuccessRate();
        Map<String, Integer> timeActivities = learningProgress.getTimeActivities();
        Map<String, Date> dateCompletion = learningProgress.getDateCompletion();

        assertEquals(1, successRate.size());
        assertEquals(0.8f, successRate.get("ACT001"));
        assertEquals(30, timeActivities.get("ACT001"));
        assertEquals(now, dateCompletion.get("ACT001"));
    }

    @Test
    void testSetFinishDate() {
        learningProgress.setFinishDate(now);
        assertEquals(now, learningProgress.getFinishDate());
    }
}

