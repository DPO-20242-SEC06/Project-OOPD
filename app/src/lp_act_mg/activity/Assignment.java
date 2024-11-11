package lp_act_mg.activity;

public class Assignment {

    public final String ASSIGNMENT = "Assignment";

    private String statusSubmission;
    private double grade;

    public Assignment(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }

    public String getStatusSubmission() {
        return statusSubmission;
    }

    public void setStatusSubmission(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }


    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }




}
