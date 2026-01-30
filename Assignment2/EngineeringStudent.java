package Assignment.Assignment2;

public class EngineeringStudent extends Student {

    private double internalMarks;
    private double externalMarks;

    public EngineeringStudent(int rollNumber, String name, int semester, double internalMarks, double externalMarks) {
        super(rollNumber, name, semester);
        this.internalMarks = internalMarks;
        this.externalMarks = externalMarks;
    }

    public double getInternalMarks() {
        return internalMarks;
    }

    public void setInternalMarks(double internalMarks) {
        this.internalMarks = internalMarks;
    }

    public double getExternalMarks() {
        return externalMarks;
    }

    public void setExternalMarks(double externalMarks) {
        this.externalMarks = externalMarks;
    }

    @Override
    public double calculateGrade() {
        double total = (internalMarks * 0.4) + (externalMarks * 0.6);
        return total;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Branch: Engineering");
        System.out.println("Internal Marks: " + internalMarks);
        System.out.println("External Marks: " + externalMarks);
        System.out.println("Grade: " + calculateGrade());
    }
}
