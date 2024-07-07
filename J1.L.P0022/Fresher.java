
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trungdbkhe140257
 */
public class Fresher extends Candidate{
    private int graduationDate;
    private String graduationRank, education;

    public Fresher() {
        
    }

    // Constructor for initializing Fresher object with provided values
    public Fresher(int graduationDate, String graduationRank, String university, String ID, String firstName, String lastName, String address, String phone, String email, int type, int birthDate) {
        super(ID, firstName, lastName, address, phone, email, type, birthDate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = university;
    }

    // Getter and setter methods for class attributes
    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String university) {
        this.education = university;
    }
    
    // Method to create a new Fresher candidate
    public void createFresher(ArrayList <Candidate> lc){
        System.out.println("==========FRESHER CANDIDATE==============");
        super.createCandidate(lc); // Call the createCandidate method of the super class (Candidate)
        setType(1); // Set the type of candidate (1 for Fresher)
        System.out.print("Graduation Date: ");
        this.setGraduationDate(inputHandle.inputGraduateDate(getBirthDate())); // Set graduation date
        System.out.print("Rank of Graduation: ");
        this.setGraduationRank(inputHandle.inputGraduationRank()); // Set graduation rank
        System.out.print("Education: ");
        this.setEducation(inputHandle.inputString()); // Set education
    }
}
