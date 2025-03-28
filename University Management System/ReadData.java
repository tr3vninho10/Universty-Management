import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
    public void readStudents(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Students")) {
            while (rs.next()) {
                System.out.printf(
                        "ID: %d | Name: %s | Email: %s\n",
                        rs.getInt("student_id"), rs.getString("name"), rs.getString("email")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readCourses(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Courses")) {
            while (rs.next()) {
                System.out.printf(
                        "ID: %d | Name: %s | Credits: %d | Instructor ID: %d\n",
                        rs.getInt("course_id"), rs.getString("course_name"), rs.getInt("credits"), rs.getInt("instructor_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readEnrollments(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Enrollments")) {
            while (rs.next()) {
                System.out.printf(
                        "Enrollment ID: %d | Student ID: %d | Course ID: %d | Score: %d | Grade: %s\n",
                        rs.getInt("enrollment_id"), rs.getInt("student_id"), rs.getInt("course_id"), rs.getInt("score"), rs.getString("grade")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}