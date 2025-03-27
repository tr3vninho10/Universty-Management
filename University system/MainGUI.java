import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainGUI extends JFrame {
    private Connection conn;

    public MainGUI(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("University Course Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnManageCourses = new JButton("Manage Courses");
        JButton btnManageStudents = new JButton("Manage Students");
        JButton btnEnrollStudents = new JButton("Enroll Students");
        JButton btnViewAnalytics = new JButton("View Analytics");
        JButton btnExit = new JButton("Exit");

        // Add action listeners
        btnManageCourses.addActionListener(e -> new ManageCoursesFrame(conn));
        btnManageStudents.addActionListener(e -> new ManageStudentsFrame(conn));
        btnEnrollStudents.addActionListener(e -> new EnrollStudentsFrame(conn));
        btnViewAnalytics.addActionListener(e -> new AnalyticsFrame(conn));
        btnExit.addActionListener(e -> System.exit(0));

        panel.add(btnManageCourses);
        panel.add(btnManageStudents);
        panel.add(btnEnrollStudents);
        panel.add(btnViewAnalytics);
        panel.add(btnExit);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("tutdb", "postgres", "zkj3jte1xke1");
        SwingUtilities.invokeLater(() -> new MainGUI(conn));
    }
}
