package ui;

import user_role_management.auth_service.AuthenticationService;
import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;  // Asegúrate de importar UserProfileManagement
import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private AuthenticationService authService;
    private static RoleManagement roleManager;
    private static UserProfileManagement userProfileManagement; 

    public LoginScreen(AuthenticationService authService, RoleManagement roleManager, UserProfileManagement userProfileManagement) {
        this.authService = authService;
        this.roleManager = roleManager;
        this.userProfileManagement = userProfileManagement;  

        setTitle("Sistema de Aprendizaje");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Sistema de Aprendizaje", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JTextField usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Usuario"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Contraseña"));

        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Estudiante", "Profesor"});
        roleComboBox.setBorder(BorderFactory.createTitledBorder("Elegir Rol"));

        JButton loginButton = new JButton("Iniciar Sesión");
        JButton registerButton = new JButton("Registrarse");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String selectedRole = (String) roleComboBox.getSelectedItem();

            if (authService.login(username, password)) {
                String role = roleManager.getUserRole(username);
                if (role == null || !role.equals(selectedRole)) {
                    JOptionPane.showMessageDialog(this, "Rol incorrecto seleccionado.");
                    return;
                }

                if ("Estudiante".equals(role)) {
                    new StudentDashboard(username).setVisible(true);
                } else if ("Profesor".equals(role)) {
                    new ProfessorDashboard(username).setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
            }
        });

        registerButton.addActionListener(e -> {
            new RegisterScreen(authService, roleManager, userProfileManagement).setVisible(true);  
            dispose();  
        });

        formPanel.add(usernameField);
        formPanel.add(passwordField);
        formPanel.add(roleComboBox);
        formPanel.add(loginButton);
        formPanel.add(registerButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        RoleManagement roleManager = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();  
        AuthenticationService authService = new AuthenticationService(roleManager, userProfileManagement);  

        SwingUtilities.invokeLater(() -> {
            new LoginScreen(authService, roleManager, userProfileManagement).setVisible(true);  
        });
    }
}

