
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trungdbkhe140257
 */
// Utility class for input validation and checking the existence of IDs, items, and duplicates in lists

public class Validate {
    static Scanner in = new Scanner(System.in);
    
    // Method to input a string with validation for empty or whitespace-only strings
    public static String inputString() {
        while(true) {
            String input = in.nextLine().trim();
            if(input.isEmpty() || input.equals(" ")) {
                System.out.println("Empty");
                System.out.print("Please enter again: ");
            } else {
                return input;
            }   
        }
    }
    
    // Method to input a double value with validation for positive numbers
    public static double inputDouble() {
        while(true) {
            try {
                double input = Double.valueOf(in.nextLine());
                if(input < 1) {
                    throw new Exception();
                }
                return input;
            } catch(NumberFormatException ex) {
                System.out.println("Wrong, you must enter a number");
                System.out.print("Enter the number : ");
            } catch(Exception ex) {
                System.out.println("Wrong, you must enter a number greater than 0");
                System.out.print("Enter the number again: ");
            }
        }
    }
    
    // Method to input an integer within a specified range with custom error message
    public static int inputNumberInRange(int min, int max, String msg) {
        while(true) {
            try {
                int input = Integer.valueOf(in.nextLine());
                if(input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch(NumberFormatException ex) {
                System.out.println("Wrong, you must enter a number");
                System.out.print("Enter the number : ");
            } catch(Exception ex) {
                System.out.println(msg);
                System.out.print("Enter again: ");
            }
        }
    }
    
    // Method to check if an ID exists in a list of fruits
    public static boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if(id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }
    
    // Method to check if an item exists in a list of orders
    public static boolean checkItemsExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if(id.equalsIgnoreCase(order.getId())) {
                return false;
            }
        }
        return true;
    }
    
    // Method to check if a fruit with the same name, origin, and price already exists in a list
    public static boolean checkDuplicate(ArrayList<Fruit> lf, String name, String origin, double price) {
        for (Fruit fruit : lf) {
            if(name.equalsIgnoreCase(fruit.getFruitName()) 
                    && origin.equalsIgnoreCase(fruit.getOrigin())
                    && price == fruit.getPrice()) {
                return false;
            }               
        }
        return true;
    }
    
    // Method to check if a fruit with the same name already exists in a list
    public static boolean checkDuplicateName(ArrayList<Fruit> lf, String name) {
        for (Fruit fruit : lf) {
            if (name.equalsIgnoreCase(fruit.getFruitName())) {
                return false;
            }
        }
        return true;
    }
    
    // Method to prompt the user to continue (Y/y) or exit (N/n) and return true for continue, false for exit
    public static boolean yesNo() {
        System.out.print("\nDo you want to continue (y/n)? : ");
        while(true) {
            String input = in.nextLine();
            if(input.equalsIgnoreCase("Y")) {
                return true;
            }
            if(input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input Y/N or y/n");
            System.out.print("Enter again: ");
        }  
    } 
}
