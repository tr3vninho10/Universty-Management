import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class AnalyticsFrame extends JFrame {
    private Connection conn;

    public AnalyticsFrame(Connection conn) {
        this.conn = conn;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Analytics Dashboard");
        setSize(1000, 800);
        setLayout(new GridLayout(2, 2));

        // Bar Chart - Students per Course
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        // Populate data from database (example)
        barDataset.addValue(25, "Students", "Java Programming");
        barDataset.addValue(30, "Students", "Database Systems");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Students per Course", "Course", "Students", barDataset
        );
        add(new ChartPanel(barChart));

        // Pie Chart - Grade Distribution
        // Similar implementation using JFreeChart

        // Table - Average Grades
        JTable gradeTable = new JTable();
        // Populate table from database
        add(new JScrollPane(gradeTable));

        setVisible(true);
    }
}
