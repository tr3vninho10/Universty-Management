import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    private final Connection conn;

    public Insert(Connection conn) {
        this.conn = conn;
    }

    public void insertInstructor(int instructorId, String name, String email, String department) {
        String query = String.format(
                "INSERT INTO Instructors (instructor_id, name, email, department) VALUES (%d, '%s', '%s', '%s')",
                instructorId, name, email, department
        );
        executeUpdate(query);
    }

    public void insertStudent(String name, String email) {
        String query = String.format(
                "INSERT INTO Students (name, email) VALUES ('%s', '%s')",
                name, email
        );
        executeUpdate(query);
    }

    public void insertCourse(int courseId, String courseName, int credits, int instructorId) {
        String query = String.format(
                "INSERT INTO Courses (course_id, course_name, credits, instructor_id) VALUES (%d, '%s', %d, %d)",
                courseId, courseName, credits, instructorId
        );
        executeUpdate(query);
    }

    public void insertEnrollment(int enrollmentId, int studentId, int courseId, int score, String grade) {
        String query = String.format(
                "INSERT INTO Enrollments (enrollment_id, student_id, course_id, score, grade) VALUES (%d, %d, %d, %d, '%s')",
                enrollmentId, studentId, courseId, score, grade
        );
        executeUpdate(query);
    }

    private void executeUpdate(String query) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Insert successful: " + query);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
}