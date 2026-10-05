import java.awt.*;
import javax.swing.*;

public class StudentRegistration extends JFrame {

    JTextField nameField;
    JTextField registerField;

    JRadioButton maleButton;
    JRadioButton femaleButton;

    JComboBox<String> departmentBox;

    JButton submitButton;

    public StudentRegistration() {

        setTitle("Student Registration System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Student Name
        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        // Register Number
        panel.add(new JLabel("Register Number:"));
        registerField = new JTextField();
        panel.add(registerField);

        // Gender
        panel.add(new JLabel("Gender:"));

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        panel.add(genderPanel);

        // Department
        panel.add(new JLabel("Department:"));

        String[] departments = {
            "Computer Science",
            "Information Technology",
            "Electronics and Communication",
            "Electrical and Electronics",
            "Mechanical"
        };

        departmentBox = new JComboBox<>(departments);
        panel.add(departmentBox);

        // Submit Button
        submitButton = new JButton("Submit");
        panel.add(new JLabel(""));
        panel.add(submitButton);

        add(panel);

        // Button action
        submitButton.addActionListener(e -> registerStudent());
    }

    private void registerStudent() {

        String name = nameField.getText().trim();
        String registerNumber = registerField.getText().trim();

        String gender;

        if (maleButton.isSelected()) {
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            gender = "Female";
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Please select gender."
            );
            return;
        }

        String department =
                (String) departmentBox.getSelectedItem();

        if (name.isEmpty() || registerNumber.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter all student details."
            );
            return;
        }

        String message =
                "Student Registration Successful!\n\n"
                + "Name: " + name + "\n"
                + "Register Number: " + registerNumber + "\n"
                + "Gender: " + gender + "\n"
                + "Department: " + department;

        JOptionPane.showMessageDialog(
            this,
            message,
            "Student Details",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            StudentRegistration window =
                    new StudentRegistration();

            window.setVisible(true);
        });
    }
}