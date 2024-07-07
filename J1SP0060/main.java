package j1.s.p0060;

import java.util.Scanner;

// Main class to start the program
public class J1SP0060 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("====== Shopping program ========");
        
        // Input information about bills from the user
        int[] bills = getBillsFromUser(scanner);
        // Input the wallet amount from the user
        int walletAmount = getWalletAmountFromUser(scanner);
        // Perform the shopping process
        performShopping(bills, walletAmount);
        
        scanner.close(); // Close the scanner object
    }
  
    // Method to receive information about bills from the user
    private static int[] getBillsFromUser(Scanner scanner){
        int numbersOfBills; // Variable to store the number of bills
        
        do{
            System.out.print("Input number of bills: ");
            while(!scanner.hasNextInt()){ // Check if the input value is an integer
                System.err.println("Please enter a valid number.");
                scanner.next(); // Discard the invalid input
            }
            numbersOfBills = scanner.nextInt();
            
            if(numbersOfBills < 0){
                System.err.println("Number of bills must be a positive integer. Please try again!");
            } else if(numbersOfBills == 0){
                System.err.println("Please enter the bills.");
            }
            
        } while (numbersOfBills <= 0); // Loop until a valid number of bills is entered
               
        int[] bills = new int[numbersOfBills]; // Create an array to store the bill values
        
        // Loop to input the values of the bills
        for(int i = 0; i < numbersOfBills; i++){
            System.out.print("Input value of bill "+ (i+1) + ": ");
            while(!scanner.hasNextInt()){
                System.err.println("Please enter a valid number.");
                scanner.next(); 
            }
            bills[i] = scanner.nextInt(); // Get the value of the bill
            
            if(bills[i] < 0){
                System.err.println("Number of bills must be a positive integer. Please try again!");
                i--; // Input the value of the current bill again
            }
        }
        return bills;
    }
    
    // Method to receive information about the wallet amount from the user
    private static int getWalletAmountFromUser(Scanner scanner){
        int walletAmount;
        boolean isValidInput;
        do{
            isValidInput = true;
            System.out.print("\nInput value of wallet: ");
            while(!scanner.hasNextInt()){
                System.err.println("Please enter a valid number.");
                scanner.next();
            }
            walletAmount = scanner.nextInt();
            if(walletAmount < 0){
                System.err.println("Number of wallet must be a positive integer. Please try again!");
                isValidInput = false;
            }
        } while(!isValidInput);
        return walletAmount;
    }
    
    // Method to perform the shopping process and determine if the user can afford the bills
    private static void performShopping(int[] bills, int walletAmount) {
        Person user = new Person(walletAmount); // Create a Person object with the wallet amount
        Wallet userWallet = user.getWallet(); // Get the wallet object from the person
        int totalBill = userWallet.calcTotal(bills); // Calculate the total bill amount

        System.out.println("Total of the bills: " + totalBill);
        if (totalBill <= 0) {
            System.out.println("\nIt's free.");
        } else if (totalBill <= walletAmount) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("\nYou can't buy it.");
        }
    }
}
