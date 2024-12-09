package ui;

import javax.swing.*;
import java.awt.*;

public class LearningPathEditor extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LearningPathEditor() {
        this(null); 
    }

    public LearningPathEditor(String learningPathName) {
        setTitle(learningPathName == null ? "Agregar Ruta" : "Editar Ruta: " + learningPathName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Título:"));
        JTextField titleField = new JTextField(learningPathName != null ? learningPathName : "");
        panel.add(titleField);

        panel.add(new JLabel("Descripción:"));
        JTextArea descriptionArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(descriptionArea));

        panel.add(new JLabel("Duración (horas):"));
        JTextField durationField = new JTextField();
        panel.add(durationField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            String description = descriptionArea.getText();
            String duration = durationField.getText();

            if (title.isEmpty() || description.isEmpty() || duration.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }
            System.out.println("Ruta guardada: " + title + " (" + duration + " horas)");
            dispose();
        });

        panel.add(saveButton);
        add(panel, BorderLayout.CENTER);
    }
}
