package ui;

import progress_feedback_system.performance_analysis.PerformanceAnalyzer;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatisticsPanel(String username) {
        setTitle("Estadísticas del Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PerformanceAnalyzer analyzer = new PerformanceAnalyzer(null);
        JPanel statsPanel = new JPanel(new GridLayout(10, 10));

        for (int i = 0; i < 100; i++) {
            JLabel cell = new JLabel();
            cell.setOpaque(true);
            cell.setBackground(i % 2 == 0 ? Color.GREEN : Color.LIGHT_GRAY);
            statsPanel.add(cell);
        }

        JButton exportButton = new JButton("Exportar Datos");
        exportButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exportación en construcción.");
        });

        add(new JScrollPane(statsPanel), BorderLayout.CENTER);
        add(exportButton, BorderLayout.SOUTH);
    }
}
