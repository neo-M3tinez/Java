/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExceptionCar {
        displayCarInformation();
    }

private static String getNonEmptyStringInput() throws ExceptionCar {
    while (true) {
        String result = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
        if (!result.isEmpty()) {
            return result;
        } else {
            System.out.println("Input must not be empty");
            System.out.print("please enter again: ");
        }
    }
}
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
                System.out.print("price is digit\n " + "Price: ");
            } catch (ExceptionCar ex) {
                System.out.println("Invalid input. " + ex.getMessage() + "\nPrice: ");
            }
        }
    }

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
            System.err.println("Re-input");
        }
    }

   private static boolean isCarValid(Car car, String color, int price, String today) throws ExceptionCar {
    boolean isColorValid = false;
    String[] availableColors = car.getColors();
    int[] availablePrices = car.getPrices();
    String[] soldDays = car.getSoldOn();

    if (!color.equalsIgnoreCase("no color")) {
        for (int i = 0; i < availableColors.length; i++) {
            if (color.equalsIgnoreCase(availableColors[i])) {
                isColorValid = true;
                break;
            }
        }
    } else {
        isColorValid = true;
    }

    if (!isColorValid) {
        throw new ExceptionCar("Color does not exist");
    }

    boolean isPriceValid = false;
    if (!color.equalsIgnoreCase("no color")) {
        for (int i = 0; i < availablePrices.length; i++) {
            if (price == availablePrices[i]) {
                isPriceValid = true;
                break;
            }
        }
    } else {
        // Check if the entered price is valid for "no color"
        if (price >= availablePrices[0] - 100 && price <= availablePrices[0]) {
            isPriceValid = true;
            price -= 100; // Decrease price by $100 for "no color"
        }
    }

    if (!isPriceValid) {
        throw new ExceptionCar("Price does not exist for this car");
    }

    boolean isSoldDayValid = false;
    for (int i = 0; i < soldDays.length; i++) {
        if (today.equalsIgnoreCase(soldDays[i])) {
            isSoldDayValid = true;
            break;
        }
    }

    if (!isSoldDayValid) {
        throw new ExceptionCar("Car cannot be sold today");
    }

    return true;
}
    private static void addCarsToInventory(ArrayList<Car> carInventory) {
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

    private static boolean isCarNameValid(ArrayList<Car> carInventory, String carName, String color, int price, String today) throws ExceptionCar {
        boolean isCarValid = false;
        for (int i = 0; i < carInventory.size(); i++) {
            if (carName.equalsIgnoreCase(carInventory.get(i).getNameCar())) {
                try {
                    isCarValid(carInventory.get(i), color, price, today);

                    System.out.println("Sell Car");
                    System.out.println("Do you want to find more? (Y/N): ");
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
