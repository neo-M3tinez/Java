/*
 * This program allows a car salesman to check if a customer's needs match the cars available in the showroom.
 * Customers can choose an unpainted car to get a $100 discount.
 * Additionally, customers can choose other options which will be added to the final price of the car.
 */

package j1.s.p0066;

import java.util.ArrayList;
import java.util.Scanner;

class ExceptionCar extends Exception {
    public ExceptionCar() {
    }

    public ExceptionCar(String message) {
        super(message);
    }
}

public class J1SP0066 {

    // Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    // Main method to start the program
    public static void main(String[] args) throws ExceptionCar {
        displayCarInformation();
    }

    // Method to get non-empty string input from the user
    private static String getNonEmptyStringInput() throws ExceptionCar {
        while (true) {
            String result = scanner.nextLine().trim(); // Remove leading/trailing spaces
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("Input must not be empty");
                System.out.print("Please enter again: ");
            }
        }
    }

    // Method to get positive integer input from the user
    private static int getPositiveIntInput() throws ExceptionCar {
        while (true) {
            try {
                String input = scanner.nextLine();
                int price = Integer.parseInt(input);

                if (price < 0) {
                    throw new ExceptionCar("Price must be greater than or equal to 0");
                }

                return price;
            } catch (NumberFormatException ex) {
                System.out.print("Price must be a number\nPrice: ");
            } catch (ExceptionCar ex) {
                System.out.println("Invalid input. " + ex.getMessage() + "Price: ");
            }
        }
    }

    // Method to get yes or no input from the user
    private static boolean getYesNoInput() throws ExceptionCar {
        while (true) {
            String result = getNonEmptyStringInput();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Please enter Y (yes) or N (no)");
        }
    }

    // Method to validate if a car is valid for sale
    private static boolean isCarValid(Car car, String color, int price, String today) throws ExceptionCar {
        String[] availableColors = car.getColors();
        int[] availablePrices = car.getPrices();
        String[] soldDays = car.getSoldOn();

        // If the color is "no color", check if the price is valid for "no color"
        if (color.equalsIgnoreCase("no color")) {
            if (price >= availablePrices[0] - 100 && price <= availablePrices[0]) {
                return checkSaleDay(soldDays, today); // Check if the car can be sold today
            } else {
                throw new ExceptionCar("Invalid price for a car with no color");
            }
        } else {
            // Check if the color is valid for the car
            boolean isColorValid = false;
            for (int i = 0; i < availableColors.length; i++) {
                if (color.equalsIgnoreCase(availableColors[i])) {
                    isColorValid = true;
                    break;
                }
            }

            if (!isColorValid) {
                throw new ExceptionCar("Color does not exist for this car");
            }

            // Check if the price is valid for the specified color
            boolean isPriceValid = false;
            for (int i = 0; i < availablePrices.length; i++) {
                if (price == availablePrices[i]) {
                    isPriceValid = true;
                    break;
                }
            }

            if (!isPriceValid) {
                throw new ExceptionCar("Price does not exist for this car and color");
            }

            // Check if the car can be sold today
            return checkSaleDay(soldDays, today);
        }
    }

    // Method to check if the car can be sold on the specified day
    private static boolean checkSaleDay(String[] soldDays, String today) throws ExceptionCar {
        for (String soldDay : soldDays) {
            if (today.equalsIgnoreCase(soldDay)) {
                return true; // Car can be sold today
            }
        }
        throw new ExceptionCar("Car cannot be sold today");
    }

    // Method to add cars to the inventory
    private static void addCarsToInventory(ArrayList<Car> carInventory) {
        // Define cars and their properties
        String[] audiColors = {"White", "Yellow", "Orange"};
        int[] audiPrices = {5500, 3000, 4500};
        String[] audiSoldDays = {"Friday", "Sunday", "Monday"};
        carInventory.add(new Car("Audi", audiColors, audiPrices, audiSoldDays));

        String[] mercedesColors = {"Green", "Blue", "Purple"};
        int[] mercedesPrices = {5000, 6000, 8500};
        String[] mercedesSoldDays = {"Tuesday", "Saturday", "Wednesday"};
        carInventory.add(new Car("Mercedes", mercedesColors, mercedesPrices, mercedesSoldDays));

        String[] bmwColors = {"Pink", "Red", "Brown"};
        int[] bmwPrices = {2500, 3000, 3500};
        String[] bmwSoldDays = {"Monday", "Sunday", "Thursday"};
        carInventory.add(new Car("BMW", bmwColors, bmwPrices, bmwSoldDays));
    }

    // Method to validate if the car name entered by the user is valid
    private static boolean isCarNameValid(ArrayList<Car> carInventory, String carName, String color, int price, String today) throws ExceptionCar {
        boolean isCarValid = false;
        for (int i = 0; i < carInventory.size(); i++) {
            if (carName.equalsIgnoreCase(carInventory.get(i).getNameCar())) {
                try {
                    isCarValid(carInventory.get(i), color, price, today);

                    System.out.println("Sell Car");
                    System.out.print("Do you want to find more? (Y/N): ");
                    if (!getYesNoInput()) {
                        return false;
                    }
                } catch (ExceptionCar ex) {
                    System.out.println("Can't sell car");
                    System.out.println(ex.getMessage());
                }
                isCarValid = true;
                break;
            }
        }
        if (!isCarValid) {
            System.out.println("Can't sell Car");
            System.out.println("Car break");
        }
        return true;
    }

    // Method to display car information and handle user input
    private static void displayCarInformation() throws ExceptionCar {
        ArrayList<Car> carInventory = new ArrayList<>();
        addCarsToInventory(carInventory);
        System.out.println("===== Showroom car program =====");
        System.out.println("Input Information of Car");
        while (true) {
            System.out.print("Name: ");
            String carName = getNonEmptyStringInput();
            System.out.print("Color: ");
            String color = getNonEmptyStringInput();
            System.out.print("Price: ");
            int price = getPositiveIntInput();
            System.out.print("Today: ");
            String today = getNonEmptyStringInput();
            if (!isCarNameValid(carInventory, carName, color, price, today)) {
                return;
            }
        }
    }
}
