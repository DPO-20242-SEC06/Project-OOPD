package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import user_role_management.user_management.Student;

public class Quiz extends Activity {

    public final String QUIZ = "Quiz";
    private int approvalGrade;
    private List<QuizQuestion> questions;


    public Quiz(int approvalGrade, String title, String description, String difficultyLevel, int expectedDuration, boolean mandatory) {
        super(title, description, difficultyLevel, expectedDuration, mandatory);
        this.approvalGrade = approvalGrade;
        this.questions = new ArrayList<>();
    }

	public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    public int getApprovalGrade() {
        return approvalGrade;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public boolean isApproved(int grade) {
        return grade >= approvalGrade;
    }

    public int getGrade(List<Option> answers) {
        int grade = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).isCorrect(answers.get(i))) {
                grade++;
            }
        }
        return grade;
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
        System.out.println("Nota de Aprobacion: " + this.approvalGrade);
        System.out.println("Preguntas: ");
    }


}
