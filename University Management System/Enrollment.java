public class Enrollment {
    private final int enrollmentId;
    private final int studentId;
    private final int courseId;
    private final int score;
    private final String grade;

    public Enrollment(int enrollmentId, int studentId, int courseId, int score, String grade) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
        this.grade = grade;
    }

    public int getEnrollmentId() { return enrollmentId; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public int getScore() { return score; }
    public String getGrade() { return grade; }
}
