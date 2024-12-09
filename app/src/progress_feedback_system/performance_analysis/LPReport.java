package progress_feedback_system.performance_analysis;

public class LPReport {
    private String learningPathId;
    private double averageCompletionTime;
    private double averageRating;
    private double successRate;


    public LPReport(String learningPathId, double averageCompletionTime, double averageRating, double successRate) {
        this.learningPathId = learningPathId;
        this.averageCompletionTime = averageCompletionTime;
        this.averageRating = averageRating;
        this.successRate = successRate;
    }


    public String generateReport() {
        return String.format(
                "Reporte de Rendimiento para el Learning Path %s\n" +
                "Tiempo promedio de finalización: %.2f horas\n" +
                "Calificación promedio: %.2f/5\n" +
                "Tasa de éxito: %.2f%%\n",
                learningPathId, averageCompletionTime, averageRating, successRate * 100
        );
    }


    public String getLearningPathId() {
        return learningPathId;
    }

    public double getAverageCompletionTime() {
        return averageCompletionTime;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public double getSuccessRate() {
        return successRate;
    }
}

