package Assignment.Assignment1;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;
        int choice;

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: Rs." + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int deposit = sc.nextInt();
                    if (deposit > 0) {
                        balance = balance + deposit;
                        System.out.println("Rs." + deposit + " deposited successfully!");
                        System.out.println("New balance: Rs." + balance);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    if (withdraw <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        balance = balance - withdraw;
                        System.out.println("Rs." + withdraw + " withdrawn successfully!");
                        System.out.println("Remaining balance: Rs." + balance);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
