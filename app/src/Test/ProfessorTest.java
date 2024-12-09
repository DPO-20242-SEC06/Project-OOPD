package Test;

import org.junit.jupiter.api.Test;

import user_role_management.user_management.Professor;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {

    @Test
    public void testCreateLearningPath() {
        Professor professor = new Professor("morganfreeman", "password123", "Morgan Freeman", "morgan@freeman.com");
        professor.createLearningPath("Narration Mastery");
        assertDoesNotThrow(() -> professor.createLearningPath("Narration Mastery"));
    }

    @Test
    public void testEditLearningPath() {
        Professor professor = new Professor("morganfreeman", "password123", "Morgan Freeman", "morgan@freeman.com");
        professor.editLearningPath("Narration Mastery");
        assertDoesNotThrow(() -> professor.editLearningPath("Narration Mastery"));
    }
}
