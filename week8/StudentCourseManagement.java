import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentCourseManagement extends JFrame {

    JList<String> courseList;
    JTable studentTable;

    JTextField studentNameField;

    JButton addButton;
    JButton removeButton;

    DefaultTableModel tableModel;

    public StudentCourseManagement() {

        setTitle("Student Course Management System");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // ================= LEFT SIDE =================

        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));

        leftPanel.add(
            new JLabel("Available Courses"),
            BorderLayout.NORTH
        );

        String[] courses = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Computer Networks",
            "Operating Systems",
            "Web Development"
        };

        courseList = new JList<>(courses);
        courseList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane courseScrollPane =
                new JScrollPane(courseList);

        leftPanel.add(
            courseScrollPane,
            BorderLayout.CENTER
        );

        // ================= RIGHT SIDE =================

        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));

        JPanel inputPanel =
                new JPanel(new GridLayout(2, 2, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));

        studentNameField = new JTextField();
        inputPanel.add(studentNameField);

        addButton = new JButton("Add Course");
        removeButton = new JButton("Remove Course");

        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        rightPanel.add(
            inputPanel,
            BorderLayout.NORTH
        );

        // ================= TABLE =================

        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        tableModel = new DefaultTableModel(columns, 0);

        studentTable = new JTable(tableModel);

        JScrollPane tableScrollPane =
                new JScrollPane(studentTable);

        rightPanel.add(
            tableScrollPane,
            BorderLayout.CENTER
        );

        // Add panels to main panel
        mainPanel.add(
            leftPanel,
            BorderLayout.WEST
        );

        mainPanel.add(
            rightPanel,
            BorderLayout.CENTER
        );

        add(mainPanel);

        // Button actions
        addButton.addActionListener(e -> addCourse());

        removeButton.addActionListener(e -> removeCourse());
    }

    // Add course registration
    private void addCourse() {

        String studentName =
                studentNameField.getText().trim();

        String selectedCourse =
                courseList.getSelectedValue();

        if (studentName.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter student name."
            );

            return;
        }

        if (selectedCourse == null) {

            JOptionPane.showMessageDialog(
                this,
                "Please select a course."
            );

            return;
        }

        tableModel.addRow(
            new Object[] {
                studentName,
                selectedCourse,
                "Enrolled"
            }
        );

        JOptionPane.showMessageDialog(
            this,
            "Course added successfully!"
        );
    }

    // Remove selected registration
    private void removeCourse() {

        int selectedRow =
                studentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                this,
                "Please select a registration from the table."
            );

            return;
        }

        tableModel.removeRow(selectedRow);

        JOptionPane.showMessageDialog(
            this,
            "Course registration removed."
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentCourseManagement window =
                    new StudentCourseManagement();

            window.setVisible(true);
        });
    }
}