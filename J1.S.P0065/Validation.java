// Validate.java
/*
 * This class provides methods to validate user input.
 */

package j1.s.p0065;

import java.util.Scanner;

public class Validate {
    static Scanner in = new Scanner(System.in);

    // Method to validate and input a number within a specified range
    public static int inputNumberInRange(String subjectName) {
        while (true) {
            try {
                int input = Integer.valueOf(in.nextLine());
                if (input < 0) {
                    System.out.println(subjectName + " must be greater than zero");
                    System.out.print(subjectName + ": ");
                    continue;
                } else if (input > 10) {
                    System.out.println(subjectName + " must be less than or equal to ten");
                    System.out.print(subjectName + ": ");
                    continue;
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.println(subjectName + " must be a digit");
                System.out.print(subjectName + ": ");
            }
        }
    }

    // Method to validate and input a string
    public static String inputString(String fieldName) {
        while (true) {
            String input = in.nextLine().trim();
            if (input.isEmpty() || input.equals(" ")) {
                System.out.println(fieldName + " must not be empty");
                System.out.println("Enter again: ");
            } else if (!Character.isLetter(input.charAt(0))) {
                System.out.println(fieldName + " must start with a character");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    // Method to validate and input a yes/no answer
    public static boolean yesNo() {
        System.out.print("\nDo you want to enter more student information? (Y/N): ");
        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input Y/N or y/n");
            System.out.print("Enter again: ");
        }
    }
}
