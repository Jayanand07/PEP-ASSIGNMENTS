package Assignment.Assignment1;

import java.util.Scanner;

public class VowelChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;

        System.out.println("===== Vowel or Consonant Checker =====");
        System.out.println("Enter # to exit\n");

        while (true) {
            System.out.print("Enter a character: ");
            ch = sc.next().charAt(0);

            if (ch == '#') {
                System.out.println("Goodbye!");
                break;
            }

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    System.out.println("Vowel");
                    break;
                default:
                    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        System.out.println("Consonant");
                    } else {
                        System.out.println("Not an alphabet!");
                    }
            }
            System.out.println();
        }

        sc.close();
    }
}
