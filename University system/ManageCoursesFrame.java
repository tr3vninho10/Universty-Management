import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class ManageCoursesFrame extends JFrame {
    private Connection conn;

    public ManageCoursesFrame(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Manage Courses");
        setSize(500, 400);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add Course Panel
        JPanel addCoursePanel = new JPanel(new GridLayout(5, 2));
        JTextField txtCourseId = new JTextField();
        JTextField txtCourseName = new JTextField();
        JTextField txtCredits = new JTextField();
        JTextField txtInstructorId = new JTextField();
        JButton btnSubmit = new JButton("Add Course");

        btnSubmit.addActionListener(e -> {
            Insert insert = new Insert(conn);
            insert.insertCourse(
                    Integer.parseInt(txtCourseId.getText()),
                    txtCourseName.getText(),
                    Integer.parseInt(txtCredits.getText()),
                    Integer.parseInt(txtInstructorId.getText())
            );
            JOptionPane.showMessageDialog(this, "Course added successfully!");
        });

        addCoursePanel.add(new JLabel("Course ID:"));
        addCoursePanel.add(txtCourseId);
        addCoursePanel.add(new JLabel("Course Name:"));
        addCoursePanel.add(txtCourseName);
        addCoursePanel.add(new JLabel("Credits:"));
        addCoursePanel.add(txtCredits);
        addCoursePanel.add(new JLabel("Instructor ID:"));
        addCoursePanel.add(txtInstructorId);
        addCoursePanel.add(new JLabel());
        addCoursePanel.add(btnSubmit);

        // View Courses Panel
        JPanel viewCoursesPanel = new JPanel(new BorderLayout());
        JTable courseTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(courseTable);
        viewCoursesPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Add Course", addCoursePanel);
        tabbedPane.addTab("View Courses", viewCoursesPanel);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
