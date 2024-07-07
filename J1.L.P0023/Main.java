
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trungdbkhe140257
 */
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Manager class
        Manager m = new Manager();
        
        // Create an ArrayList to store fruits
        ArrayList<Fruit> fruitList = new ArrayList<>();
        
        // Create a Hashtable to store shopping carts for each customer
        Hashtable<String, ArrayList<Order>> cart = new Hashtable<>();
        
        // Continuously prompt the user with the menu options until they choose to exit
        while(true) {
            // Display the menu and get user's choice
            int choice = m.menu();
            
            // Perform actions based on user's choice
            switch(choice) {
                case 1:
                    // Create a new fruit and add it to the fruit list
                    m.createFruit(fruitList);
                    break;
                case 2:
                    // View orders stored in the shopping cart hashtable
                    m.viewOrder(cart);
                    break;
                case 3: 
                    // Allow a buyer to shop for fruits and add items to their cart
                    m.shopping(fruitList, cart);
                    break;
                case 4:
                    // Exit the program
                    return;
            }
        }
    }
}
