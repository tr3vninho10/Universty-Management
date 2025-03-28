public class Course {
    private final int courseId;
    private final String courseName;
    private final int credits;
    private final int instructorId;

    public Course(int courseId, String courseName, int credits, int instructorId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.instructorId = instructorId;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public int getInstructorId() { return instructorId; }
}
