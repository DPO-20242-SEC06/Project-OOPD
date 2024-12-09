package Test;
import progress_feedback_system.progress_tracking.Attempt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AttemptTest {

    private Attempt attempt;

    @BeforeEach
    void setUp() {
        Date now = new Date();
        attempt = new Attempt(30, true, true, true, "A+", now, now);
    }

    @Test
    void testGetDuration() {
        assertEquals(30, attempt.getDuration());
    }

    @Test
    void testIsCompleted() {
        assertTrue(attempt.isCompleted());
    }

    @Test
    void testIsApproved() {
        assertTrue(attempt.isApproved());
    }

    @Test
    void testIsGrade() {
        assertTrue(attempt.isGrade());
    }

    @Test
    void testGetResult() {
        assertEquals("A+", attempt.getResult());
    }

    @Test
    void testGetFinishDate() {
        assertNotNull(attempt.getFinishDate());
    }

    @Test
    void testGetInitDate() {
        assertNotNull(attempt.getInitDate());
    }
}
