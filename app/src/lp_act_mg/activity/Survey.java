package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;
import user_role_management.user_management.Student;

public class Survey extends Activity {

    public final String SURVEY = "Survey";
    private String statusSubmission;
    private List<SurveyQuestion> questions;

    public Survey(String statusSubmission , String title, String description, String difficultyLevel, int expectedDuration, boolean mandatory) {
        super(title, description, difficultyLevel, expectedDuration, mandatory);
        this.statusSubmission = statusSubmission;
        this.questions = new ArrayList<>(); 
    }

    public void addQuestion(SurveyQuestion question) {
        questions.add(question);
    }

    public List<SurveyQuestion> getQuestions() {
        return questions;
    }

    public String getStatusSubmission() {
        return statusSubmission;
    }

    public void setStatusSubmission(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }

    @Override
    public boolean isCompleted(Student student) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void showActivity() {
        // TODO Auto-generated method stub
        System.out.println("Titulo: " + this.title);
        System.out.println("Descripcion: " + this.description);
        System.out.println("Nivel de Dificultad: " + this.difficultyLevel);
        System.out.println("Tiempo de duracion: " + this.expectedDuration);
    }

}
