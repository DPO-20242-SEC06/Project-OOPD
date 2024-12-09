package ui;

import javax.swing.*;
import java.awt.*;

public class TaskEvaluationScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskEvaluationScreen() {
        setTitle("Evaluación de Tareas/Exámenes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel taskListPanel = new JPanel();
        taskListPanel.setBorder(BorderFactory.createTitledBorder("Tareas/Exámenes Pendientes"));
        JList<String> taskList = new JList<>(new String[]{"Tarea 1", "Examen 1"});
        taskListPanel.add(new JScrollPane(taskList));

        JPanel evaluationPanel = new JPanel(new BorderLayout());
        JTextArea commentArea = new JTextArea();
        commentArea.setBorder(BorderFactory.createTitledBorder("Comentario"));
        JButton approveButton = new JButton("Aprobar");
        JButton rejectButton = new JButton("Rechazar");

        approveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Tarea aprobada."));
        rejectButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Tarea rechazada."));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        evaluationPanel.add(new JScrollPane(commentArea), BorderLayout.CENTER);
        evaluationPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(taskListPanel, BorderLayout.WEST);
        add(evaluationPanel, BorderLayout.CENTER);
    }
}
