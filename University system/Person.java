// Parent class for shared attributes
abstract class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {  // Now works for both Instructor & Student
        return id;
    }

    public String getName() {
        return name;
    }
}

// Instructor class extending Person
class Instructor extends Person {
    private final String department;

    public Instructor(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

// Student class extending Person
class Student extends Person {
    private final String email;

    public Student(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

// Course class
class Course {
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

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getInstructorId() {
        return instructorId;
    }
}

// Enrollment class
class Enrollment {
    private final int studentId;
    private final int courseId;
    private final String grade;

    public Enrollment(int studentId, int courseId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getGrade() {
        return grade;
    }
}

// Attendance class
class Attendance {
    private final int studentId;
    private final int courseId;
    private final String date;
    private final String status;

    public Attendance(int studentId, int courseId, String date, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}

