package Assignment.Assignment2;

public class MedicalStudent extends Student {

    private double theoryMarks;
    private double practicalMarks;
    private double vivaMarks;

    public MedicalStudent(int rollNumber, String name, int semester, double theoryMarks, double practicalMarks,
            double vivaMarks) {
        super(rollNumber, name, semester);
        this.theoryMarks = theoryMarks;
        this.practicalMarks = practicalMarks;
        this.vivaMarks = vivaMarks;
    }

    public double getTheoryMarks() {
        return theoryMarks;
    }

    public void setTheoryMarks(double theoryMarks) {
        this.theoryMarks = theoryMarks;
    }

    public double getPracticalMarks() {
        return practicalMarks;
    }

    public void setPracticalMarks(double practicalMarks) {
        this.practicalMarks = practicalMarks;
    }

    public double getVivaMarks() {
        return vivaMarks;
    }

    public void setVivaMarks(double vivaMarks) {
        this.vivaMarks = vivaMarks;
    }

    @Override
    public double calculateGrade() {
        double total = (theoryMarks * 0.5) + (practicalMarks * 0.3) + (vivaMarks * 0.2);
        return total;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Branch: Medical");
        System.out.println("Theory Marks: " + theoryMarks);
        System.out.println("Practical Marks: " + practicalMarks);
        System.out.println("Viva Marks: " + vivaMarks);
        System.out.println("Grade: " + calculateGrade());
    }
}
