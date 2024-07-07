package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create an ArrayList to store contacts
        ArrayList<Contact> lc = new ArrayList<>();
        // Add some initial contacts to the list
        lc.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        lc.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        lc.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
        
        // Loop to display the menu and handle user input
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createContact(lc);
                    break;
                case 2:
                    Manager.printAllContact(lc);
                    break;
                case 3:
                    Manager.deleteContact(lc);
                    break;
                case 4:
                    return;
            }
        }
    }
}
