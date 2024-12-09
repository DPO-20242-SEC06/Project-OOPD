package progress_feedback_system.performance_analysis;

import progress_feedback_system.feedback_system.FeedbackManager;
import progress_feedback_system.progress_tracking.LearningProgress;

import java.util.*;

public class PerformanceAnalyzer {
    private Map<String, LPReport> learningPathReports;
    private FeedbackManager feedbackManager;

    public PerformanceAnalyzer(FeedbackManager feedbackManager) {
        this.learningPathReports = new HashMap<>();
        this.feedbackManager = feedbackManager;
    }

    public LPReport generateReport(String learningPathId) {
        List<LearningProgress> progresses = simulateLearningProgressData(learningPathId); 
        
        double averageRating = feedbackManager.getAverageRatingLP(learningPathId); 

        double totalCompletionTime = progresses.stream().mapToDouble(LearningProgress::getCompletionPercentage).sum();
        double averageCompletionTime = progresses.isEmpty() ? 0 : totalCompletionTime / progresses.size();
        
        double successRate = progresses.stream()
                .mapToDouble(lp -> lp.getSuccessRate().values().stream().mapToDouble(Float::doubleValue).average().orElse(0))
                .average()
                .orElse(0);

        LPReport report = new LPReport(learningPathId, averageCompletionTime, averageRating, successRate);
        learningPathReports.put(learningPathId, report);
        return report;
    }

    public void correlateFeedbackWithReport(String learningPathId) {
        LPReport report = learningPathReports.get(learningPathId);
        if (report != null) {
            System.out.println(report.generateReport());
        } else {
            System.out.println("No se encontró el reporte para el Learning Path especificado.");
        }
    }

    public List<LearningProgress> simulateLearningProgressData(String learningPathId) {
        List<LearningProgress> progressList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            LearningProgress progress = new LearningProgress(
                    learningPathId,
                    new Date(System.currentTimeMillis() - random.nextInt(1_000_000_000))
            );
            progress.updateCompletionPercentage(random.nextInt(101));
            progress.addActivityData("activity" + i, random.nextFloat(), random.nextInt(120), new Date());
            progressList.add(progress);
        }
        return progressList;
    }
}

