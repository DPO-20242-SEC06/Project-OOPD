package progress_feedback_system.progress_tracking;

import java.util.*;

public class ProgressTracker {
    private Map<String, List<LearningProgress>> studentProgress; 

    public ProgressTracker() {
        this.studentProgress = new HashMap<>();
    }

    public LearningProgress getStudentProgress(String studentId, String learningPathId) {
        return studentProgress.getOrDefault(studentId, new ArrayList<>())
                .stream()
                .filter(lp -> lp.getLearningPathId().equals(learningPathId))
                .findFirst()
                .orElse(null);
    }

    public void updateLearningPathProgress(LearningProgress learningProgress, Attempt attempt) {
        if (attempt.isCompleted()) {
            learningProgress.updateCompletionPercentage(learningProgress.getCompletionPercentage() + 10.0);
            learningProgress.addActivityData(UUID.randomUUID().toString(), attempt.isApproved() ? 1.0f : 0.5f, attempt.getDuration(), attempt.getFinishDate());
        }
    }

    public double getLearningPathProgress(String studentId, String learningPathId) {
        LearningProgress progress = getStudentProgress(studentId, learningPathId);
        return progress != null ? progress.getCompletionPercentage() : 0.0;
    }

    public void endLearningPath(String studentId, String learningPathId, Date finishDate) {
        LearningProgress progress = getStudentProgress(studentId, learningPathId);
        if (progress != null) {
            progress.setFinishDate(finishDate);
            progress.updateCompletionPercentage(100.0);
        }
    }

    public void enrollLearningPath(String studentId, String learningPathId, Date initDate) {
        studentProgress.computeIfAbsent(studentId, k -> new ArrayList<>())
                .add(new LearningProgress(learningPathId, initDate));
    }

    public void endActivity(String studentId, String learningPathId, Date finishDate) {
        LearningProgress progress = getStudentProgress(studentId, learningPathId);
        if (progress != null) {
            progress.setFinishDate(finishDate);
        }
    }

    
    public void initActivity(String studentId, String learningPathId, Date initDate) {
        enrollLearningPath(studentId, learningPathId, initDate);
    }
}
