package Test;

import progress_feedback_system.feedback_system.FeedbackManager;
import progress_feedback_system.performance_analysis.LPReport;
import progress_feedback_system.performance_analysis.PerformanceAnalyzer;
import progress_feedback_system.progress_tracking.LearningProgress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

class PerformanceAnalyzerTest {

    private PerformanceAnalyzer performanceAnalyzer;
    private FeedbackManager feedbackManager;

    @BeforeEach
    void setUp() {
        feedbackManager = new FeedbackManager();
        performanceAnalyzer = new PerformanceAnalyzer(feedbackManager);
    }

    @Test
    void testGenerateReport() {
        String learningPathId = "LP001";

        LPReport report = performanceAnalyzer.generateReport(learningPathId);

        assertNotNull(report);
        assertEquals(learningPathId, report.getLearningPathId());
        assertTrue(report.getAverageCompletionTime() >= 0 && report.getAverageCompletionTime() <= 100);
        assertTrue(report.getAverageRating() >= 0 && report.getAverageRating() <= 5);
        assertTrue(report.getSuccessRate() >= 0 && report.getSuccessRate() <= 1);
    }

    @Test
    void testCorrelateFeedbackWithReport() {
        String learningPathId = "LP001";
        
        performanceAnalyzer.generateReport(learningPathId);

        performanceAnalyzer.correlateFeedbackWithReport(learningPathId);
        
    }

    @Test
    void testSimulateLearningProgressData() {
        String learningPathId = "LP001";
        
        List<LearningProgress> progressList = performanceAnalyzer.simulateLearningProgressData(learningPathId);
        
        assertNotNull(progressList);
        assertTrue(progressList.size() > 0);

        LearningProgress firstProgress = progressList.get(0);
        assertEquals(learningPathId, firstProgress.getLearningPathId());
        assertTrue(firstProgress.getCompletionPercentage() >= 0 && firstProgress.getCompletionPercentage() <= 100);
    }
}
