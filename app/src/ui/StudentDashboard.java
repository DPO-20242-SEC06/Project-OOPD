package ui;

import user_role_management.auth_service.AuthenticationService;
import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;
import progress_feedback_system.progress_tracking.ProgressTracker;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private String username;

    public StudentDashboard(String username) {
        this.username = username;

        setTitle("Panel de Estudiante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuProfile = new JMenu("Mi Perfil");
        JMenu menuLearningPaths = new JMenu("Rutas de Aprendizaje");
        JMenu menuStats = new JMenu("Estadísticas");
        JMenu menuLogout = new JMenu("Cerrar Sesión");

        menuProfile.addActionListener(e -> {
            UserProfileManagement userProfileManagement = new UserProfileManagement();
            String profileInfo = userProfileManagement.getUserProfile(username).toString();
            JOptionPane.showMessageDialog(this, profileInfo, "Perfil", JOptionPane.INFORMATION_MESSAGE);
        });

        menuLearningPaths.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidad en construcción.");
        });

        menuStats.addActionListener(e -> {
            ProgressTracker tracker = new ProgressTracker();
            JOptionPane.showMessageDialog(this, "Estadísticas en construcción.");
        });

        menuLogout.addActionListener(e -> {
            RoleManagement roleManager = new RoleManagement();
            UserProfileManagement userProfileManagement = new UserProfileManagement();
            AuthenticationService authService = new AuthenticationService(roleManager, userProfileManagement);
            
            new LoginScreen(authService, roleManager, userProfileManagement).setVisible(true);
            dispose();
        });

        menuBar.add(menuProfile);
        menuBar.add(menuLearningPaths);
        menuBar.add(menuStats);
        menuBar.add(menuLogout);

        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Bienvenido, " + username));
        add(mainPanel);
    }
}

