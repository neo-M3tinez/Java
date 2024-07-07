package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final static Scanner in = new Scanner(System.in);
    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    public static final String VALID_NAME = "[a-zA-Z]+(\\s[a-zA-Z]+)*";
    public static final String VALID_ADDRESS = "[a-zA-Z0-9]+(\\s[a-zA-Z0-9]+)*";


    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check input string with only characters
    public static String checkInputCharacterString(String regex) {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            if (result.matches(regex)) {
                return result;
            }
            System.err.println("Please input only characters.");
            System.out.print("Enter again: ");
        }
    }

    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check input int
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    //check input positive int
    public static int checkInputPositiveId(ArrayList<Contact> lc) {
        //loop until user input correct
        while (true) {
            int result = checkInputInt();
            if (result > 0 && !isIdExist(lc, result)) {
                return result;
            }
            if (isIdExist(lc, result)) {
                System.out.println("ID already exists. Please enter a different one.");
            } else {
                System.out.println("ID must be a positive number.");
            }
            System.out.print("Enter again: ");
        }
    }

    //check input phone
    public static String checkInputPhone() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone flow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }

    //check if ID exists
    public static boolean isIdExist(ArrayList<Contact> lc, int id) {
        for (Contact contact : lc) {
            if (contact.getContactId() == id) {
                return true;
            }
        }
        return false;
    }
}
