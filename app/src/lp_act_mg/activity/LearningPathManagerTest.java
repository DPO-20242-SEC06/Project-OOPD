package lp_act_mg.activity;

import lp_act_mg.activity.Activity;
import lp_act_mg.activity.ActivityManager;
import lp_act_mg.learning_path.LearningPath;
import lp_act_mg.learning_path.LearningPathManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LearningPathManagerTest {

    private LearningPathManager learningPathManager;
    private ActivityManager activityManager;

    @BeforeEach
    void setUp() {
        activityManager = new ActivityManager();
        learningPathManager = new LearningPathManager(activityManager);
    }

    @Test
    void testCreateLearningPath() {
        String title = "Java Programming";
        String description = "A comprehensive course on Java.";
        String objectives = "Learn Java basics, Object-Oriented Programming, and Java frameworks.";
        String difficultyLevel = "Intermediate";

        learningPathManager.createLearningPath(title, description, objectives, difficultyLevel);

        List<LearningPath> learningPaths = learningPathManager.listAllLearningPaths();
        assertEquals(1, learningPaths.size());
        assertEquals(title, learningPaths.get(0).getTitle());
        assertEquals(description, learningPaths.get(0).getDescription());
        assertEquals(objectives, learningPaths.get(0).getObjectives());
        assertEquals(difficultyLevel, learningPaths.get(0).getDifficultyLevel());
    }

    @Test
    void testEditLearningPath() {
        String title = "Java Programming";
        String description = "A comprehensive course on Java.";
        String objectives = "Learn Java basics, Object-Oriented Programming, and Java frameworks.";
        String difficultyLevel = "Intermediate";

        learningPathManager.createLearningPath(title, description, objectives, difficultyLevel);

        LearningPath learningPath = learningPathManager.listAllLearningPaths().get(0);
        String newTitle = "Advanced Java Programming";
        String newDescription = "An advanced course covering Java topics in depth.";
        String newObjectives = "Master Java concepts and advanced frameworks.";

        learningPathManager.editLearningPath(learningPath.getId(), newTitle, newDescription, newObjectives);

        LearningPath updatedLearningPath = learningPathManager.getLearningPath(learningPath.getId());
        assertNotNull(updatedLearningPath);
        assertEquals(newTitle, updatedLearningPath.getTitle());
        assertEquals(newDescription, updatedLearningPath.getDescription());
        assertEquals(newObjectives, updatedLearningPath.getObjectives());
    }

    @Test
    void testDeleteLearningPath() {
        String title = "Java Programming";
        String description = "A comprehensive course on Java.";
        String objectives = "Learn Java basics, Object-Oriented Programming, and Java frameworks.";
        String difficultyLevel = "Intermediate";

        learningPathManager.createLearningPath(title, description, objectives, difficultyLevel);

        List<LearningPath> learningPaths = learningPathManager.listAllLearningPaths();
        assertEquals(1, learningPaths.size());

        String learningPathId = learningPaths.get(0).getId();
        learningPathManager.deleteLearningPath(learningPathId);

        learningPaths = learningPathManager.listAllLearningPaths();
        assertEquals(0, learningPaths.size());
    }


    @Test
    void testGetLearningPath() {
        String title = "Java Programming";
        String description = "A comprehensive course on Java.";
        String objectives = "Learn Java basics, Object-Oriented Programming, and Java frameworks.";
        String difficultyLevel = "Intermediate";

        learningPathManager.createLearningPath(title, description, objectives, difficultyLevel);

        LearningPath learningPath = learningPathManager.listAllLearningPaths().get(0);
        LearningPath retrievedLearningPath = learningPathManager.getLearningPath(learningPath.getId());

        assertNotNull(retrievedLearningPath);
        assertEquals(learningPath.getId(), retrievedLearningPath.getId());
        assertEquals(learningPath.getTitle(), retrievedLearningPath.getTitle());
    }
}

