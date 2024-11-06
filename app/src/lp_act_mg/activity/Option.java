package lp_act_mg.activity;

public class Option {
    private String textOption;
    private String explanation;

    public Option(String textOption, String explanation) {
        this.textOption = textOption;
        this.explanation = explanation;
    }

    public String getTextOption() {
        return textOption;
    }

    public void setTextOption(String textOption) {
        this.textOption = textOption;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
