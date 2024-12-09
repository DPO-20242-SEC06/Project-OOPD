package ui;

import lp_act_mg.activity.Option;
import lp_act_mg.activity.Quiz;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class QuizEvaluationScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizEvaluationScreen(Quiz quiz) {
        setTitle("Evaluación de Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        ButtonGroup[] answerGroups = new ButtonGroup[quiz.getQuestions().size()];

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            JLabel questionLabel = new JLabel((i + 1) + ". " + quiz.getQuestions().get(i).getQuestion());
            questionPanel.add(questionLabel);

            answerGroups[i] = new ButtonGroup();
            JPanel answerPanel = new JPanel(new FlowLayout());
            for (Option option : quiz.getQuestions().get(i).getOptions()) {
                JRadioButton optionButton = new JRadioButton((Icon) option);
                answerGroups[i].add(optionButton);
                answerPanel.add(optionButton);
            }
            questionPanel.add(answerPanel);
        }

        JButton submitButton = new JButton("Enviar Respuestas");
        submitButton.addActionListener(e -> {
            int score = 0;
            for (int i = 0; i < quiz.getQuestions().size(); i++) {
                Option correctAnswer = quiz.getQuestions().get(i).getCorrectAnswer();
                for (Enumeration<AbstractButton> buttons = answerGroups[i].getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected() && button.getText().equals(correctAnswer)) {
                        score++;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Tu calificación es: " + score + "/" + quiz.getQuestions().size());
        });

        add(new JScrollPane(questionPanel), BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
}
