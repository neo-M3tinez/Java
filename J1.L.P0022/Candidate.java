import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * This class represents a Candidate with various attributes such as ID, name, address, phone, email, etc.
 * 
 * @author trungdbkhe140257
 */
public class Candidate {
    private String ID, firstName, lastName, address, phone, email;
    private int type, birthDate;

    public Candidate() {
    }

    // Constructor for initializing Candidate object with provided values
    public Candidate(String ID, String firstName, String lastName, String address, String phone, String email, int type, int birthDate) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.birthDate = birthDate;
    }

    // Getter and setter methods for class attributes
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    
    // Override toString() method to provide custom string representation of Candidate object
    public String toString(){
        return firstName + " " + lastName + " | " + birthDate + " | " +address 
                + " | " + phone + " | " + email + " | " + type;
    }
    
    // Method to create a new Candidate object
    public void createCandidate(ArrayList <Candidate> lc){
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            System.out.print("ID: ");
            this.setID(inputHandle.inputID(lc));
            System.out.print("First Name: ");
            this.setFirstName(inputHandle.inputStringWithoutNumbers());
            System.out.print("Last Name: ");
            this.setLastName(inputHandle.inputStringWithoutNumbers());
            System.out.print("Birth Date: ");
            this.setBirthDate(inputHandle.inputNumberInRange(1900, currentYear, 
                    "Please input between 1900 and " + currentYear));
            System.out.print("Address: ");
            this.setAddress(inputHandle.inputAddress());
            System.out.print("Phone: ");
            this.setPhone(inputHandle.inputPhone());
            System.out.print("Email: ");
            this.setEmail(inputHandle.inputEmail(lc));
        
    }
}
