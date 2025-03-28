// Person(abstract class)
abstract class Person {
    protected int id;
    protected String name;
    protected String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void displayDetails();

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Instructor subclass
class Instructor extends Person {
    private final String department;

    public Instructor(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instructor ID: " + id + " | Name: " + name);
    }

    public String getDepartment() { return department; }
}

// Student subclass
class Student extends Person {
    public Student(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + id + " | Name: " + name);
    }
}