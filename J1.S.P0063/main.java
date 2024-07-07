import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Check and receive the number of persons from the user
        int n = checkInputNumberPerson();
        // Create an array persons to store information of the persons
        Person[] persons = new Person[n];

        // Input information of n persons from the user
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }

        // Initialize the listPersonWrapper array to store information of the persons and sort them by salary
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);

        // Display information of the persons sorted by salary
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i].person.displayPersonInfo();
        }
    }

    // Method to check and return a character input from the user
    private static String checkInputString() {
        while (true) {
            String input = in.nextLine().trim();
            if (!input.isEmpty() && input.matches("[a-zA-Z]+")) {
                return input;
            } else {
                System.err.println("Input must be a non-empty string containing only letters.");
                System.out.print("Please input name: ");
            }
        }
    }

    // Method to check and return an integer input from the user
    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be a positive integer.");
            }
        }
    }

    // Method to check and return a floating-point number input from the user
    private static double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.err.println("Salary must be greater than or equal to zero.");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Input must be a valid number.");
            }
        }
    }

    // Method to check and return the number of persons input from the user
    private static int checkInputNumberPerson() {
        System.out.print("Enter number of persons: ");
        return checkInputInt();
    }

    // Method to check and return an address input from the user
    private static String checkInputAddress() {
        while (true) {
            System.out.print("Please input address: ");
            String address = in.nextLine().trim();
            if (address.matches(".*[a-zA-Z].*")) {
                return address;
            } else {
                System.err.println("Address must contain at least one letter.");
            }
        }
    }

    // Method to input information of a person from the user
    private static Person inputPersonInfo() {
        System.out.println("=====Management Person programer=====");
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        String address = checkInputAddress();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Person(String.valueOf(name), address, salary);
    }

    // Method to swap the positions of two PersonWrapper objects
    private static void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.person;
        person1.person = person2.person;
        person2.person = temp;
    }

    // Method to sort an array of PersonWrapper objects by salary
    private static void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        // Initialize the listPersonWrapper array with elements being PersonWrapper objects containing information from the persons array
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }

        // Sort the listPersonWrapper array by salary
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].person.salary > listPersonWrapper[j].person.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.err.println("Sort success.");
    }
}
