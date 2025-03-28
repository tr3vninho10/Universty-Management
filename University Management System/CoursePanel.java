import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class CoursePanel extends JPanel {
    private final Connection conn;
    private JTable courseTable;

    public CoursePanel(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Add Course Form
        JPanel formPanel = new JPanel(new GridLayout(0, 2));
        JTextField nameField = new JTextField();
        JTextField creditsField = new JTextField();
        JButton addButton = new JButton("Add Course");

        formPanel.add(new JLabel("Course Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Credits:"));
        formPanel.add(creditsField);
        formPanel.add(addButton);

        // Course Table
        courseTable = new JTable();
        refreshTable();

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(courseTable), BorderLayout.CENTER);

        // Add Course Action
        addButton.addActionListener(e -> {
            String courseName = nameField.getText();
            int credits = Integer.parseInt(creditsField.getText());
            new Insert(conn).insertCourse(0, courseName, credits, 1); // Assume instructor_id=1 for demo
            refreshTable();
            nameField.setText("");
            creditsField.setText("");
        });
    }

    private void refreshTable() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Course Name", "Credits", "Instructor ID"}, 0);
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Courses")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits"),
                        rs.getInt("instructor_id")
                });
            }
            courseTable.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
