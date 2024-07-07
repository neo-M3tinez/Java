package main;

import java.util.ArrayList;

public class Contact {

    private int contactId;
    private String fullName;
    private String group;
    private String address;
    private String phone;
    private String firstName;
    private String lastName;

    // Constructor for Contact class
    public Contact() {
    }

    public Contact(int contactId, String fullName, String group, String address, String phone, String firstName, String lastName) {
        this.contactId = contactId;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters for Contact class properties
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        // Split the full name into first name and last name
        String[] nameParts = fullName.split("\\s+", 2); // Split on whitespace, max 2 parts
        this.firstName = "";
        this.lastName = "";
        if (nameParts.length > 0) {
            this.firstName = nameParts[0];
            if (nameParts.length > 1) {
                this.lastName = nameParts[1];
            }
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

}
