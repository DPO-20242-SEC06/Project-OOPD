package ui;

import lp_act_mg.learning_path.LearningPath;

import javax.swing.*;
import java.awt.*;

public class LearningPathDetailScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LearningPathDetailScreen(LearningPath learningPath) {
        setTitle("Detalles de la Ruta de Aprendizaje");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new GridLayout(5, 1));
        topPanel.add(new JLabel("Título: " + learningPath.getTitle()));
        topPanel.add(new JLabel("Descripción: " + learningPath.getDescription()));
        topPanel.add(new JLabel("Objetivos: " + learningPath.getObjectives()));
        topPanel.add(new JLabel("Nivel: " + learningPath.getDifficultyLevel()));

        JPanel activityPanel = new JPanel();
        activityPanel.setLayout(new BoxLayout(activityPanel, BoxLayout.Y_AXIS));
        learningPath.getActivities().forEach(activity -> {
            JButton activityButton = new JButton(activity.getTitle());
            activityButton.addActionListener(e -> {
                new ActivityScreen(activity).setVisible(true);
            });
            activityPanel.add(activityButton);
        });

        JButton backButton = new JButton("Volver al Menú Principal");
        backButton.addActionListener(e -> dispose());

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(activityPanel), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
