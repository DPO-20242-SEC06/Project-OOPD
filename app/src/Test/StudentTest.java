package Test;

import org.junit.jupiter.api.Test;

import user_role_management.user_management.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testEnrollLearningPath() {
        Student student = new Student("selenagomez", "password123", "Selena Gomez", "selena@gomez.com", "Pop, Acting");

        student.enrollLearningPath("Acting 101");
        assertDoesNotThrow(() -> student.enrollLearningPath("Acting 101"));
    }

    @Test
    public void testCompleteActivity() {
        Student student = new Student("selenagomez", "password123", "Selena Gomez", "selena@gomez.com", "Pop, Acting");

        student.completeActivity("Voice Training");
        assertDoesNotThrow(() -> student.completeActivity("Voice Training"));
    }
}
