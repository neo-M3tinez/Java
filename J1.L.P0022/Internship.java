
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LTT
 */
public class Internship extends Candidate{
    private String major;
    private String semester;
    private String university;

    public Internship() {
        super();
    }

    // Constructor for initializing Internship object with provided values
    public Internship(String major, String semester, String university, String ID, String firstName, String lastName, String address, String phone, String email, int type, int birthDate) {
        super(ID, firstName, lastName, address, phone, email, type, birthDate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    // Getter and setter methods for class attributes
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
    // Method to create a new Internship candidate
    public void createInternship(ArrayList <Candidate> listCandi){
        System.out.println("===========INTERN CANDIDATE==============");
        super.createCandidate(listCandi); // Call the createCandidate method of the super class (Candidate)
        setType(2); // Set the type of candidate (2 for Intern)
        System.out.print("Major: ");
        this.setMajor(inputHandle.inputStringWithoutNumbers());
        System.out.print("Semester: ");
        this.setSemester(inputHandle.inputStringWithoutNumbers());
        System.out.print("University Name: ");
        this.setUniversity(inputHandle.inputStringWithoutNumbers());
    }
    
}
