package lp_act_mg.activity;

import java.util.Date;
import user_role_management.user_management.Student;

public class ConcreteActivity extends Activity {

    public ConcreteActivity(String id, String description, String difficultyLevel, int expectedDuration, Date limitDate, boolean mandatory) {
        super(description, difficultyLevel, difficultyLevel, expectedDuration, mandatory);
        this.setId(id);
        this.setLearningPath(null); 
    }

    @Override
    public boolean isCompleted(Student student) {
        return false;
    }

    @Override
    public void showActivity() {
        System.out.println("Activity: " + this.getTitle());
    }
}
