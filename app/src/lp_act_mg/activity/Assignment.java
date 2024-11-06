package lp_act_mg.activity;

public class Assignment {

    public final String ASSIGNMENT = "Assignment";

    private String statusSubmission;
    private String statement;
    private double grade;

    public Assignment(String statusSubmission, String statement) {
        this.statusSubmission = statusSubmission;
        this.statement = statement;
    }

    public String getStatusSubmission() {
        return statusSubmission;
    }

    public void setStatusSubmission(String statusSubmission) {
        this.statusSubmission = statusSubmission;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }




}
