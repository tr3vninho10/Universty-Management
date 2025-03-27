import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class ManageStudentsFrame extends JFrame {
    private Connection conn;

    public ManageStudentsFrame(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Manage Students");
        setSize(500, 400);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add Student Panel
        JPanel addStudentPanel = new JPanel(new GridLayout(4, 2));
        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtEmail = new JTextField();
        JButton btnSubmit = new JButton("Add Student");

        btnSubmit.addActionListener(e -> {
            Insert insert = new Insert(conn);
            insert.insertStudent(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtEmail.getText()
            );
            JOptionPane.showMessageDialog(this, "Student added successfully!");
        });

        addStudentPanel.add(new JLabel("Student ID:"));
        addStudentPanel.add(txtId);
        addStudentPanel.add(new JLabel("Name:"));
        addStudentPanel.add(txtName);
        addStudentPanel.add(new JLabel("Email:"));
        addStudentPanel.add(txtEmail);
        addStudentPanel.add(new JLabel());
        addStudentPanel.add(btnSubmit);

        // View Students Panel
        JPanel viewStudentsPanel = new JPanel(new BorderLayout());
        JTable studentTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(studentTable);
        viewStudentsPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Add Student", addStudentPanel);
        tabbedPane.addTab("View Students", viewStudentsPanel);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
