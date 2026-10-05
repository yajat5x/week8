import java.awt.*;
import javax.swing.*;

public class UserLoginPreferences extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    JCheckBox rememberMe;
    JCheckBox notifications;

    JButton loginButton;

    public UserLoginPreferences() {

        setTitle("User Login System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Username
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Remember Me
        panel.add(new JLabel("Preferences:"));

        JPanel preferencePanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        preferencePanel.add(rememberMe);
        preferencePanel.add(notifications);

        panel.add(preferencePanel);

        // Login Button
        panel.add(new JLabel(""));

        loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        // Login button action
        loginButton.addActionListener(e -> login());
    }

    private void login() {

        String username = usernameField.getText().trim();
        String password =
                new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter username and password.",
                "Login Error",
                JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String message =
                "Login Successful!\n\n"
                + "Username: " + username + "\n"
                + "Remember Me: "
                + (rememberMe.isSelected() ? "Yes" : "No") + "\n"
                + "Receive Notifications: "
                + (notifications.isSelected() ? "Yes" : "No");

        JOptionPane.showMessageDialog(
            this,
            message,
            "Login",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            UserLoginPreferences window =
                    new UserLoginPreferences();

            window.setVisible(true);
        });
    }
}