import java.sql.Connection;
import java.sql.Statement;

public class DeleteData {

    private String formatCondition(Object value) {
        return (value instanceof String) ? "'" + value + "'" : value.toString();
    }

    public void deleteData(Connection conn, String table_name, String conditionColumn, Object conditionValue) {
        try (Statement statement = conn.createStatement()) {
            String query = String.format(
                    "DELETE FROM %s WHERE %s = %s;",
                    table_name,
                    conditionColumn,
                    formatCondition(conditionValue)
            );

            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        } catch (Exception e) {
            System.out.println(e); // Keep original error printing style
        }
    }

    // Schema-aligned convenience methods
    public void deleteStudent(Connection conn, int studentId) {
        deleteData(conn, "Students", "student_id", studentId);
    }

    public void deleteInstructor(Connection conn, int instructorId) {
        deleteData(conn, "Instructors", "instructor_id", instructorId);
    }

    public void deleteCourse(Connection conn, int courseId) {
        deleteData(conn, "Courses", "course_id", courseId);
    }

    public void deleteEnrollment(Connection conn, int enrollmentId) {
        deleteData(conn, "Enrollments", "enrollment_id", enrollmentId);
    }

    public void deleteAttendance(Connection conn, int studentId) {
        deleteData(conn, "Attendance", "student_id", studentId);
    }

}



