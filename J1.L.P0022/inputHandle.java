import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class inputHandle {
    static Scanner in = new Scanner(System.in);

    // Method for inputting a string from the user
    public static String inputString() {
        while (true) {
            String input = in.nextLine().trim();
            // Check if the string is empty or only contains whitespace
            if (input.isEmpty() || input.equals(" ")) {
                System.out.println("Empty!!!");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    // Method to check the validity of an ID
    public static boolean isValidID(String ID) {
        // Check if the ID contains non-digit characters
        if (!ID.matches("\\d+")) {
            return false;
        }
        
        // Convert the ID to an integer to check if it's greater than or equal to 1
        int idNumber = Integer.parseInt(ID);
        return idNumber >= 1;
    }

    // Method for inputting a number within a specified range
    public static int inputNumberInRange(int min, int max, String msg) {
        while (true) {
            try {
                int input = Integer.valueOf(in.nextLine());
                if (input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.println("Wrong, you must enter a number");
                System.out.print("Enter the number : ");
            } catch (Exception ex) {
                System.out.println(msg);
                System.out.print("Enter again: ");
            }
        }
    }

    // Method for inputting a yes or no answer
    public static boolean yesNo() {
        System.out.print("\nDo you want to continue: ");
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

    // Method for inputting a phone number
    public static String inputPhone() {
        while (true) {
            String input = in.nextLine();
            // If the string contains exactly 10 digits, return
            if (input.matches("^\\d{10}\\d*$")) {
                return input;
            } else {
                System.out.println("Phone is number with minimum 10 numbers");
                System.out.print("Phone: ");
            }
        }
    }

    // Method for inputting an email address
    public static String inputEmail() {
        while (true) {
            String input = in.nextLine();
            // If the email address matches the regex pattern, return
            if (input.matches("[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$")) {
                return input;
            } else {
                System.out.println("Email is string with format <account name>@<domain>.<domain>");
                System.out.print("Email: ");
            }
        }
    }

    // Method for inputting graduation rank
    public static String inputGraduationRank() {
        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Excellence")
                    || input.equalsIgnoreCase("Good")
                    || input.equalsIgnoreCase("Fair")
                    || input.equalsIgnoreCase("Poor")) {
                return input;
            }
            System.out.println("Rank is one of 4 values (Excellence, Good, Fair, Poor)");
            System.out.print("Enter again: ");
        }
    }

    // Method for inputting years of experience
    public static int inputExperience(int birthDate) {
        // Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - birthDate;
        while (true) {
            int experienceYear = inputNumberInRange(1, age, "Experience years must be smaller than age: " + age);
            if (experienceYear > age) {
                System.out.println("Experiment must be smaller than age");
            } else {
                return experienceYear;
            }
        }
    }

    // Method for inputting graduation year
    public static int inputGraduateDate(int birthDate) {
        // Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - birthDate;
        while (true) {
            int graduateDate = inputNumberInRange(age, Integer.MAX_VALUE, "Graduate date must greater than birth date!!!");
            return graduateDate;
        }
    }

    // Method to check the uniqueness of an ID
    public static boolean checkID(ArrayList<Candidate> lc, String ID) {
        for (Candidate candidate : lc) {
            if (ID.equalsIgnoreCase(candidate.getID())) {
                return false;
            }
        }
        return true;
    }

    // Method to input ID, check validity and uniqueness
    public static String inputID(ArrayList<Candidate> lc) {
        while (true) {
            String input = inputString();
            // Check the validity of the ID
            if (!isValidID(input)) {
                System.out.println("Invalid ID. ID must be a number greater than or equal to 1.");
                System.out.print("Enter again: ");
            }
            // Check the uniqueness of the ID
            else if (!checkID(lc, input)) {
                System.out.println("ID duplicated!!!");
                System.out.print("ID: ");
            } else {
                return input;
            }
        }
    }
}
