import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AnalyticsPanel extends JPanel {
    private final Connection conn;

    public AnalyticsPanel(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        JPanel chartPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        chartPanel.add(createBarChart());
        chartPanel.add(createPieChart());

        JButton refreshButton = new JButton("Refresh Charts");
        refreshButton.addActionListener(e -> refreshCharts());

        add(chartPanel, BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);
    }

    private ChartPanel createBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT c.course_name, COUNT(e.student_id) AS students " +
                "FROM Enrollments e " +
                "JOIN Courses c ON e.course_id = c.course_id " +
                "GROUP BY c.course_name";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("students"), "Students", rs.getString("course_name"));
            }
        } catch (SQLException e) {
            System.out.println("Bar chart error: " + e.getMessage());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Students per Course", "Course", "Number of Students", dataset
        );
        return new ChartPanel(chart);
    }

    private ChartPanel createPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String query = "SELECT grade, COUNT(*) AS count FROM Enrollments GROUP BY grade";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                dataset.setValue(rs.getString("grade"), rs.getInt("count"));
            }
        } catch (SQLException e) {
            System.out.println("Pie chart error: " + e.getMessage());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Grade Distribution", dataset, true, true, false
        );
        return new ChartPanel(chart);
    }

    private void refreshCharts() {
        removeAll();
        initializeUI();
        revalidate();
        repaint();
    }
}
