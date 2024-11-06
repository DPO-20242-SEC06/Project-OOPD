package lp_act_mg.activity;

public class ExamQuestion extends Question {

    
	private String expectedAnswer;

	public ExamQuestion(String statement, String expectedAnswer) {
		super(statement);
		this.expectedAnswer = expectedAnswer;
	}

    public ExamQuestion() {
        super(null);
    }

	@Override
	public void showStatement() {
		System.out.println("Question: " + this.statement);
	}

}
