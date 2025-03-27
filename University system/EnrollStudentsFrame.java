import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class EnrollStudentsFrame extends JFrame {
    private Connection conn;

    public EnrollStudentsFrame(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Enroll Students");
        setSize(500, 300);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField txtStudentId = new JTextField();
        JTextField txtCourseId = new JTextField();
        JTextField txtGrade = new JTextField();
        JButton btnSubmit = new JButton("Enroll Student");

        btnSubmit.addActionListener(e -> {
            Insert insert = new Insert(conn);
            insert.insertEnrollment(
                    Integer.parseInt(txtStudentId.getText()),
                    Integer.parseInt(txtCourseId.getText()),
                    txtGrade.getText()
            );
            JOptionPane.showMessageDialog(this, "Enrollment successful!");
        });

        add(new JLabel("Student ID:"));
        add(txtStudentId);
        add(new JLabel("Course ID:"));
        add(txtCourseId);
        add(new JLabel("Grade:"));
        add(txtGrade);
        add(new JLabel());
        add(btnSubmit);

        setVisible(true);
    }
}
