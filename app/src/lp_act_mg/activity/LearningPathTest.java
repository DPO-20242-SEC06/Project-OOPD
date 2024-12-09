package lp_act_mg.activity;

import lp_act_mg.activity.Activity;
import lp_act_mg.learning_path.LearningPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearningPathTest {

    private LearningPath learningPath;

    @BeforeEach
    void setUp() {
        learningPath = new LearningPath("1", "Java Programming", "A course on Java", "Learn Java", "Intermediate");
    }
}