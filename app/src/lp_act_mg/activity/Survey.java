package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    public final String SURVEY = "Survey";
    private String statusSubmission;
    private List<SurveyQuestion> questions;

    public Survey(String statusSubmission) {
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

}
