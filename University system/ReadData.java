import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {

    public void readStudents(Connection conn) {
        try {
            String query = "SELECT * FROM Students";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("student_id") + " ");
                System.out.print(rs.getString("student_name") + " ");
                System.out.println(rs.getString("email") + " ");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readCourses(Connection conn) {
        try {
            String query = "SELECT * FROM Courses";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("course_id") + " ");
                System.out.print(rs.getString("course_name") + " ");
                System.out.print(rs.getInt("credits") + " ");
                System.out.println(rs.getInt("instructor_id") + " ");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readInstructors(Connection conn) {
        try {
            String query = "SELECT * FROM Instructors";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("instructor_id") + " ");
                System.out.print(rs.getString("instructor_name") + " ");
                System.out.println(rs.getString("department") + " ");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readEnrollments(Connection conn) {
        try {
            String query = "SELECT * FROM Enrollments";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("enrollment_id") + " ");
                System.out.print(rs.getInt("student_id") + " ");
                System.out.print(rs.getInt("course_id") + " ");
                System.out.println(rs.getString("grade") + " ");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readAttendance(Connection conn) {
        try {
            String query = "SELECT * FROM Attendance";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("student_id") + " ");
                System.out.print(rs.getInt("course_id") + " ");
                System.out.print(rs.getString("date") + " ");
                System.out.println(rs.getString("status") + " ");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




