package Test;
import progress_feedback_system.performance_analysis.LPReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LPReportTest {

    private LPReport lpReport;

    @BeforeEach
    void setUp() {
        lpReport = new LPReport("LP001", 80.5, 4.2, 0.75);
    }

    @Test
    void testGenerateReport() {
        String report = lpReport.generateReport();
        assertNotNull(report);
        assertTrue(report.contains("Learning Path LP001"));
        assertTrue(report.contains("80.50"));
        assertTrue(report.contains("4.20"));
        assertTrue(report.contains("75.00"));
    }

    @Test
    void testGetters() {
        assertEquals("LP001", lpReport.getLearningPathId());
        assertEquals(80.5, lpReport.getAverageCompletionTime());
        assertEquals(4.2, lpReport.getAverageRating());
        assertEquals(0.75, lpReport.getSuccessRate());
    }
}
