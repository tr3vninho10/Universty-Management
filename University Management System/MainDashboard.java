import javax.swing.*;
import java.sql.Connection;

public class MainDashboard extends JFrame {
    private final Connection conn;
    private JTabbedPane tabbedPane;

    public MainDashboard(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("University Course Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Students", new StudentPanel(conn));
        tabbedPane.addTab("Courses", new CoursePanel(conn));
        tabbedPane.addTab("Enrollments", new EnrollmentPanel(conn));
        tabbedPane.addTab("Analytics", new AnalyticsPanel(conn));

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("University_db", "postgres", "zkj3jte1xke1");
        if (conn != null) {
            SwingUtilities.invokeLater(() -> new MainDashboard(conn));
        }
    }
}