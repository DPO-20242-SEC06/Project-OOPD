package ui;

import user_role_management.auth_service.AuthenticationService;
import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;

import javax.swing.*;

public class ProfessorDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private String username;

    public ProfessorDashboard(String username) {
        this.username = username;

        setTitle("Panel de Profesor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuProfile = new JMenu("Mi Perfil");
        JMenu menuAdmin = new JMenu("Admin");
        JMenu menuLogout = new JMenu("Cerrar Sesión");

        menuProfile.addActionListener(e -> {
            UserProfileManagement userProfileManagement = new UserProfileManagement();
            String profileInfo = userProfileManagement.getUserProfile(username).toString();
            JOptionPane.showMessageDialog(this, profileInfo, "Perfil", JOptionPane.INFORMATION_MESSAGE);
        });

        menuAdmin.addActionListener(e -> {
            new AdminPanel(username).setVisible(true);
        });

        menuLogout.addActionListener(e -> {
            RoleManagement roleManager = new RoleManagement();
            UserProfileManagement userProfileManagement = new UserProfileManagement();
            AuthenticationService authService = new AuthenticationService(roleManager, userProfileManagement);
            new LoginScreen(authService, roleManager, userProfileManagement).setVisible(true);
            dispose();
        });

        menuBar.add(menuProfile);
        menuBar.add(menuAdmin);
        menuBar.add(menuLogout);

        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Bienvenido, Profesor " + username));
        add(mainPanel);
    }
}

