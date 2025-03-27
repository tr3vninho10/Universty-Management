import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    private final Connection conn;

    public Insert(Connection conn) {
        this.conn = conn;
    }

    public void insertInstructor(int instructorId, String name, String department) {
        String query = "INSERT INTO Instructors (instructor_id, instructor_name, department) VALUES ("
                + instructorId + ", '" + name + "', '" + department + "')";
        executeUpdate(query);
    }

    public void insertStudent(int studentId, String name, String email) {
        String query = "INSERT INTO Students (student_id, student_name, email) VALUES ("
                + studentId + ", '" + name + "', '" + email + "')";
        executeUpdate(query);
    }

    public void insertCourse(int courseId, String courseName, int credits, int instructorId) {
        String query = "INSERT INTO Courses (course_id, course_name, credits, instructor_id) VALUES ("
                + courseId + ", '" + courseName + "', " + credits + ", " + instructorId + ")";
        executeUpdate(query);
    }

    public void insertEnrollment(int studentId, int courseId, String grade) {
        String query = "INSERT INTO Enrollments (student_id, course_id, grade) VALUES ("
                + studentId + ", " + courseId + ", '" + grade + "')";
        executeUpdate(query);
    }

    public void insertAttendance(int studentId, int courseId, String date, String status) {
        String query = "INSERT INTO Attendance (student_id, course_id, date, status) VALUES ("
                + studentId + ", " + courseId + ", '" + date + "', '" + status + "')";
        executeUpdate(query);
    }

    private void executeUpdate(String query) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Insert successful: " + query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
