package main;

import java.util.ArrayList;

public class Manager {

    // Method to display the menu and get user choice
    public static int menu() {
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        // Validate user input to ensure it's within range 1-4
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    // Method to allow user to create a contact
    public static void createContact(ArrayList<Contact> lc) {
        System.out.println("-------- Add a Contact --------");
        System.out.print("Enter ID: ");
        // Validate user input for a positive ID that does not already exist in the list
        int contactId = Validation.checkInputPositiveId(lc);
        System.out.print("Enter Name: ");
        // Validate user input for the name
        String name = Validation.checkInputCharacterString(Validation.VALID_NAME);
        // Split the name into first name and last name
        String[] nameParts = name.split("\\s+", 2); // Split on whitespace, max 2 parts
        String firstName = "";
        String lastName = "";
        if (nameParts.length > 0) {
            firstName = nameParts[0];
            if (nameParts.length > 1) {
                lastName = nameParts[1];
            }
        }
        System.out.print("Enter Group: ");
        // Validate user input for the group, allowing only characters
        String group = Validation.checkInputCharacterString(Validation.VALID_NAME);
        System.out.print("Enter Address: ");
        // Validate user input for the address, allowing alphanumeric characters and spaces
        String address = Validation.checkInputCharacterString(Validation.VALID_ADDRESS);
        System.out.print("Enter Phone: ");
        // Validate user input for the phone number
        String phone = Validation.checkInputPhone();
        // Create a new contact object and add it to the list
        lc.add(new Contact(contactId, name, group, address, phone, firstName, lastName));
        System.out.println("Successful\n");
    }

    // Method to allow user to display all contacts
    public static void printAllContact(ArrayList<Contact> lc) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        // Loop through the list of contacts and print each contact's details
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-15s%-15s%-15s%-15s%-15s\n",
                    contact.getContactId(), contact.getFullName(), contact.getFirstName(),
                    contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
        System.out.println();
    }

    // Method to allow user to delete a contact
    public static void deleteContact(ArrayList<Contact> lc) {
        System.out.println("------- Delete a Contact -------");
        System.out.print("Enter ID: ");
        // Validate user input for the ID of the contact to delete
        int idDelete = Validation.checkInputInt();
        // Find the contact with the given ID in the list
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            // If contact with given ID is not found, display error message
            System.out.println("ID is not found.");
        } else {
            // If contact with given ID is found, remove it from the list
            lc.remove(contactDelete);
            System.out.println("Successful\n");
        }
    }

    // Method to get a contact by ID from the list
    public static Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        // Loop through the list of contacts
        for (Contact contact : lc) {
            // If contact ID matches the given ID, return the contact
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        // If contact with given ID is not found, return null
        return null;
    }
}
