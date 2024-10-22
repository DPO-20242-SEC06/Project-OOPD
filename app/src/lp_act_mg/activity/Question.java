package lp_act_mg.activity;

public abstract class Question {
    protected String statement;

    protected Question(String statement) {
        this.statement = statement;
    }

    public abstract void showStatement();
}
