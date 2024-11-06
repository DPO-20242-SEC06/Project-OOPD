package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    public final String EXAM = "Exam";
    private int grade;
    private String statusSubmission;
    private List<ExamQuestion> questions;

    public Exam(String statusSubmission) {
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

    public int getGrade() {
        return grade;
    }

    public String getStatusSubmission() {
        return statusSubmission;
    }

    public void setStatusSubmission(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }

}
