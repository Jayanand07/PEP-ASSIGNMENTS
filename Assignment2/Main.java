package Assignment.Assignment2;

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        Student.displayUniversityName();
        System.out.println();

        EngineeringStudent engStudent = new EngineeringStudent(101, "Rahul Kumar", 4, 85.5, 78.0);
        MedicalStudent medStudent = new MedicalStudent(102, "Priya Sharma", 3, 90.0, 88.0, 85.0);
        AllRounderStudent allRounder = new AllRounderStudent(103, "Amit Singh", 5, 80.0, 90.0, 85.0);

        System.out.println("--- Engineering Student ---");
        engStudent.displayDetails();
        System.out.println();

        System.out.println("--- Medical Student ---");
        medStudent.displayDetails();
        System.out.println();

        System.out.println("--- All Rounder Student ---");
        allRounder.displayDetails();
        System.out.println();

        System.out.println("========================================");
        System.out.println("   POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================\n");

        Student s1 = engStudent;
        Student s2 = medStudent;
        Student s3 = allRounder;

        System.out.println("Calling calculateGrade() using Student reference:");
        System.out.println("Engineering Student Grade: " + s1.calculateGrade());
        System.out.println("Medical Student Grade: " + s2.calculateGrade());
        System.out.println("All Rounder Grade: " + s3.calculateGrade());
        System.out.println();

        System.out.println("========================================");
        System.out.println("   INTERFACE POLYMORPHISM");
        System.out.println("========================================\n");

        SportsParticipant sportsPlayer = allRounder;
        CulturalParticipant culturalPlayer = allRounder;

        sportsPlayer.playSport();
        culturalPlayer.performActivity();
        System.out.println();

        System.out.println("========================================");
        System.out.println("   SHOWING UNIVERSITY RULES");
        System.out.println("========================================\n");

        engStudent.showRules();

        System.out.println("\n========================================");
        System.out.println("   END OF DEMONSTRATION");
        System.out.println("========================================");
    }
}
