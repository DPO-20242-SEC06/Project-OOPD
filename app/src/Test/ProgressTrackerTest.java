package Test;

import progress_feedback_system.progress_tracking.Attempt;
import progress_feedback_system.progress_tracking.LearningProgress;
import progress_feedback_system.progress_tracking.ProgressTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTrackerTest {

    private ProgressTracker progressTracker;
    private String studentId = "student001";
    private String learningPathId = "LP001";
    private Date now;

    @BeforeEach
    void setUp() {
        progressTracker = new ProgressTracker();
        now = new Date();
    }

    @Test
    void testEnrollLearningPath() {
        progressTracker.enrollLearningPath(studentId, learningPathId, now);

        LearningProgress progress = progressTracker.getStudentProgress(studentId, learningPathId);
        assertNotNull(progress);
        assertEquals(0.0, progress.getCompletionPercentage());
        assertEquals(learningPathId, progress.getLearningPathId());
    }

    @Test
    void testUpdateLearningPathProgress() {
        progressTracker.enrollLearningPath(studentId, learningPathId, now);
        LearningProgress progress = progressTracker.getStudentProgress(studentId, learningPathId);

        Attempt attempt = new Attempt(30, true, true, true, "A", now, now);
        progressTracker.updateLearningPathProgress(progress, attempt);

        assertEquals(10.0, progress.getCompletionPercentage());
    }

    @Test
    void testEndLearningPath() {
        progressTracker.enrollLearningPath(studentId, learningPathId, now);
        LearningProgress progress = progressTracker.getStudentProgress(studentId, learningPathId);

        progressTracker.endLearningPath(studentId, learningPathId, now);
        assertEquals(100.0, progress.getCompletionPercentage());
        assertEquals(now, progress.getFinishDate());
    }

    @Test
    void testGetLearningPathProgress() {
        progressTracker.enrollLearningPath(studentId, learningPathId, now);
        LearningProgress progress = progressTracker.getStudentProgress(studentId, learningPathId);

        assertEquals(0.0, progressTracker.getLearningPathProgress(studentId, learningPathId));

        Attempt attempt = new Attempt(30, true, true, true, "A", now, now);
        progressTracker.updateLearningPathProgress(progress, attempt);

        assertEquals(10.0, progressTracker.getLearningPathProgress(studentId, learningPathId));
    }
}

