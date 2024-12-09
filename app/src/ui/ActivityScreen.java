package ui;

import lp_act_mg.activity.Activity;

import javax.swing.*;
import java.awt.*;

public class ActivityScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActivityScreen(Activity activity) {
        setTitle("Actividad: " + activity.getTitle());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JTextArea contentArea = new JTextArea(activity.getDescription());
        contentArea.setEditable(false);
        contentPanel.add(new JScrollPane(contentArea), BorderLayout.CENTER);

        JButton completeButton = new JButton("Marcar como Completada");
        completeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Actividad completada.");
            dispose();
        });

        JButton backButton = new JButton("Volver al Detalle de Ruta");
        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(backButton);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
