package ui;

import user_role_management.auth_service.AuthenticationService;
import user_role_management.role_management.RoleManagement;
import user_role_management.user_management.UserProfileManagement;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private AuthenticationService authService;
    private RoleManagement roleManager;
    private UserProfileManagement userProfileManagement;

    public RegisterScreen(AuthenticationService authService, RoleManagement roleManager, UserProfileManagement userProfileManagement) {
        this.authService = authService;
        this.roleManager = roleManager;
        this.userProfileManagement = userProfileManagement;

        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Registrar Usuario", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JTextField usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Usuario"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Contraseña"));

        JTextField nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Nombre"));

        JTextField emailField = new JTextField();
        emailField.setBorder(BorderFactory.createTitledBorder("Correo Electrónico"));

        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Estudiante", "Profesor"});
        roleComboBox.setBorder(BorderFactory.createTitledBorder("Elegir Rol"));

        JButton registerButton = new JButton("Registrarse");

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String name = nameField.getText();
            String email = emailField.getText();
            String selectedRole = (String) roleComboBox.getSelectedItem();

            // Validación básica
            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                return;
            }

            // Registrar el nuevo usuario
            if (authService.registerUser(username, password, name, email, selectedRole)) {
                JOptionPane.showMessageDialog(this, "Registro exitoso.");
                new LoginScreen(authService, roleManager, userProfileManagement).setVisible(true);
                dispose();  // Cerrar la ventana de registro
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya existe.");
            }
        });

        formPanel.add(usernameField);
        formPanel.add(passwordField);
        formPanel.add(nameField);
        formPanel.add(emailField);
        formPanel.add(roleComboBox);
        formPanel.add(registerButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        RoleManagement roleManager = new RoleManagement();
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        AuthenticationService authService = new AuthenticationService(roleManager, userProfileManagement);

        SwingUtilities.invokeLater(() -> {
            new RegisterScreen(authService, roleManager, userProfileManagement).setVisible(true);
        });
    }
}

