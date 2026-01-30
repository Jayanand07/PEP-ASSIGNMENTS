package Assignment.Assignment2;

public abstract class Student {

    private int rollNumber;
    private String name;
    private int semester;

    public static String universityName;
    public final int MAX_SEMESTER = 8;

    static {
        universityName = "ABC University";
    }

    public Student(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        setSemester(semester);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester < 0) {
            System.out.println("Semester cannot be negative! Setting to 1.");
            this.semester = 1;
        } else if (semester > MAX_SEMESTER) {
            System.out.println("Semester cannot exceed " + MAX_SEMESTER + "! Setting to " + MAX_SEMESTER);
            this.semester = MAX_SEMESTER;
        } else {
            this.semester = semester;
        }
    }

    public abstract double calculateGrade();

    public void displayDetails() {
        System.out.println("Roll Number: " + getRollNumber());
        System.out.println("Name: " + getName());
        System.out.println("Semester: " + getSemester());
        System.out.println("University: " + universityName);
    }

    public static void displayUniversityName() {
        System.out.println("University Name: " + universityName);
    }

    public final void showRules() {
        System.out.println("=== University Rules ===");
        System.out.println("1. Attendance must be above 75%");
        System.out.println("2. No ragging allowed");
        System.out.println("3. Follow dress code");
    }
}
