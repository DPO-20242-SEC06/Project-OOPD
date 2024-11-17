package lp_act_mg.activity;

import java.util.ArrayList;
import java.util.List;


public class QuizQuestion {

    private List<Option> options;
    private Option correctOption;

    public QuizQuestion(List<Option> options, Option correctOption) {
        this.options = new ArrayList<>(options);
        this.correctOption = correctOption;
    }

    public void addQuestion(Option option) {
        options.add(option);
    }

    public void setCorrectOption(Option correctOption) {
        this.correctOption = correctOption;
    }

    public List<Option> getOptions() {
        return options;
    }

    public Option getCorrectOption() {
        return correctOption;
    }

    public boolean isCorrect(Option option) {
        return correctOption.equals(option);
    }
    

    
}
