package Assignment.Assignment2;

public class AllRounderStudent extends Student implements SportsParticipant, CulturalParticipant {

    private double academicMarks;
    private double sportsMarks;
    private double culturalMarks;

    public AllRounderStudent(int rollNumber, String name, int semester, double academicMarks, double sportsMarks,
            double culturalMarks) {
        super(rollNumber, name, semester);
        this.academicMarks = academicMarks;
        this.sportsMarks = sportsMarks;
        this.culturalMarks = culturalMarks;
    }

    public double getAcademicMarks() {
        return academicMarks;
    }

    public void setAcademicMarks(double academicMarks) {
        this.academicMarks = academicMarks;
    }

    public double getSportsMarks() {
        return sportsMarks;
    }

    public void setSportsMarks(double sportsMarks) {
        this.sportsMarks = sportsMarks;
    }

    public double getCulturalMarks() {
        return culturalMarks;
    }

    public void setCulturalMarks(double culturalMarks) {
        this.culturalMarks = culturalMarks;
    }

    @Override
    public double calculateGrade() {
        double total = (academicMarks * 0.5) + (sportsMarks * 0.25) + (culturalMarks * 0.25);
        return total;
    }

    @Override
    public void playSport() {
        System.out.println(getName() + " is playing Cricket!");
    }

    @Override
    public void performActivity() {
        System.out.println(getName() + " is performing Dance!");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: All Rounder");
        System.out.println("Academic: " + academicMarks);
        System.out.println("Sports: " + sportsMarks);
        System.out.println("Cultural: " + culturalMarks);
        System.out.println("Grade: " + calculateGrade());
    }
}
