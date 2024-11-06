package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public final String QUIZ = "Quiz";
    private int approvalGrade;
    private List<QuizQuestion> questions;


    public Quiz(int approvalGrade) {
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


}
