package lp_act_mg.learning_path;

import lp_act_mg.activity.Activity;
import lp_act_mg.activity.ActivityManager;

import java.util.*;

/**
 * Clase para gestionar rutas de aprendizaje.
 */
public class LearningPathManager {
    private List<LearningPath> learningPaths;
    private ActivityManager activityManager;

    public LearningPathManager(ActivityManager activityManager) {
        this.learningPaths = new ArrayList<>();
        this.activityManager = activityManager;
    }

    public void createLearningPath(String title, String description, String objectives, String difficultyLevel) {
        String id = UUID.randomUUID().toString();
        LearningPath newLearningPath = new LearningPath(id, title, description, objectives, difficultyLevel);
        this.learningPaths.add(newLearningPath);
        System.out.println("Learning Path created successfully: " + newLearningPath.getTitle());
    }

    public void editLearningPath(String learningPathId, String newTitle, String newDescription, String newObjectives) {
        for (LearningPath lp : this.learningPaths) {
            if (lp.getId().equals(learningPathId)) {
                lp.setTitle(newTitle);
                lp.setDescription(newDescription);
                lp.setObjectives(newObjectives);
                System.out.println("Learning Path updated successfully.");
                return;
            }
        }
        System.out.println("Learning Path ID not found.");
    }

    public void deleteLearningPath(String learningPathId) {
        this.learningPaths.removeIf(lp -> lp.getId().equals(learningPathId));
        System.out.println("Learning Path deleted successfully.");
    }

    public void assignActivitiesToLearningPath(String learningPathId, List<Activity> activities) {
        for (LearningPath lp : this.learningPaths) {
            if (lp.getId().equals(learningPathId)) {
                for (Activity activity : activities) {
                    lp.addActivity(activity);
                }
                System.out.println("Activities assigned successfully to the learning path.");
                return;
            }
        }
        System.out.println("Learning Path ID not found.");
    }

    public LearningPath getLearningPath(String learningPathId) {
        for (LearningPath lp : this.learningPaths) {
            if (lp.getId().equals(learningPathId)) {
                return lp;
            }
        }
        return null;
    }

    public List<LearningPath> listAllLearningPaths() {
        return this.learningPaths;
    }
}

