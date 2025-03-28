import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EnrollmentPanel extends JPanel {
    private final Connection conn;
    private JTable enrollmentTable;

    public EnrollmentPanel(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Add Enrollment Form
        JPanel formPanel = new JPanel(new GridLayout(0, 2));
        JTextField studentIdField = new JTextField();
        JTextField courseIdField = new JTextField();
        JTextField scoreField = new JTextField();
        JButton addButton = new JButton("Enroll Student");

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(studentIdField);
        formPanel.add(new JLabel("Course ID:"));
        formPanel.add(courseIdField);
        formPanel.add(new JLabel("Score:"));
        formPanel.add(scoreField);
        formPanel.add(addButton);

        // Enrollment Table
        enrollmentTable = new JTable();
        refreshTable();

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(enrollmentTable), BorderLayout.CENTER);

        // Add Enrollment Action
        addButton.addActionListener(e -> {
            int studentId = Integer.parseInt(studentIdField.getText());
            int courseId = Integer.parseInt(courseIdField.getText());
            int score = Integer.parseInt(scoreField.getText());
            String grade = calculateGrade(score); // Auto-calculate grade
            new Insert(conn).insertEnrollment(0, studentId, courseId, score, grade);
            refreshTable();
            studentIdField.setText("");
            courseIdField.setText("");
            scoreField.setText("");
        });
    }

    private void refreshTable() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Enrollment ID", "Student ID", "Course ID", "Score", "Grade"}, 0);
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Enrollments")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getInt("score"),
                        rs.getString("grade")
                });
            }
            enrollmentTable.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Convert score to grade (e.g., 85 → 'A')
    private String calculateGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else return "F";
    }
}
