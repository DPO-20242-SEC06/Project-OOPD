package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;
import user_role_management.user_management.Student;

public class Exam extends Activity {

    public final String EXAM = "Exam";
    private double grade;
    private String statusSubmission;
    private List<ExamQuestion> questions;

    public Exam(String statusSubmission, String title, String description, String difficultyLevel, int expectedDuration, boolean mandatory) {
        super(title, description, difficultyLevel, expectedDuration, mandatory);
        this.statusSubmission = statusSubmission;
        this.questions = new ArrayList<>(); 

    }

    public void addQuestion(ExamQuestion question) {
        questions.add(question);
    }

    public List<ExamQuestion> getQuestions() {
        return questions;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double  getGrade() {
        return grade;
    }

    public String getStatusSubmission() {
        return statusSubmission;
    }

    public void setStatusSubmission(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }

    @Override
    public boolean isCompleted(Student student) {
        return false;
    }

    @Override
    public void showActivity() {
        System.out.println("Titulo: " + this.title);
        System.out.println("Descripcion: " + this.description);
        System.out.println("Nivel de Dificultad: " + this.difficultyLevel);
        System.out.println("Tiempo de duracion: " + this.expectedDuration);
        System.out.println("Estado de Entrega: " + this.statusSubmission);
        System.out.println("Preguntas: ");
    }


}
