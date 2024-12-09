package ui;

import lp_act_mg.learning_path.LearningPath;
import lp_act_mg.learning_path.LearningPathManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminPanel extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LearningPathManager learningPathManager;

    public AdminPanel(String username) {
        setTitle("Panel de Administración");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        learningPathManager = new LearningPathManager(null);

        JPanel routeListPanel = new JPanel(new BorderLayout());
        JList<String> routeList = new JList<>(getLearningPaths());
        routeListPanel.add(new JScrollPane(routeList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Agregar Ruta");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Eliminar");

        addButton.addActionListener(e -> new LearningPathEditor().setVisible(true));
        editButton.addActionListener(e -> {
            String selectedPath = routeList.getSelectedValue();
            if (selectedPath != null) {
                new LearningPathEditor(selectedPath).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una ruta para editar.");
            }
        });
        deleteButton.addActionListener(e -> {
            String selectedPath = routeList.getSelectedValue();
            if (selectedPath != null) {
                learningPathManager.deleteLearningPath(selectedPath);
                JOptionPane.showMessageDialog(this, "Ruta eliminada.");
                routeList.setListData(getLearningPaths());
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una ruta para eliminar.");
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        routeListPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(routeListPanel, BorderLayout.WEST);

        JPanel reviewPanel = new JPanel();
        reviewPanel.setBorder(BorderFactory.createTitledBorder("Reseñas"));
        reviewPanel.add(new JLabel("Aquí se mostrarán las reseñas de los estudiantes."));

        add(reviewPanel, BorderLayout.CENTER);
    }

    private String[] getLearningPaths() {
        List<LearningPath> paths = learningPathManager.listAllLearningPaths();
        return paths.toArray(new String[0]);
    }
}
