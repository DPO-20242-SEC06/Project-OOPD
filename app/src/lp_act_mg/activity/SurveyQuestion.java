package lp_act_mg.activity;

public class SurveyQuestion extends Question {

	private String answer;

	public SurveyQuestion(String statement) {
		super(statement);
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	@Override
	public void showStatement() {
		System.out.println("Question: " + this.statement);
	}

}
