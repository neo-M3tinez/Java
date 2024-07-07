import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * This class represents an Experience candidate, inheriting from the Candidate class.
 * 
 * @author trungdbkhe140257
 */
public class Experience extends Candidate{
    private int yearExperience;
    private String professionalSkill;

    public Experience() {
        super();
    }

    // Constructor for initializing Experience object with provided values
    public Experience(int yearExperience, String professionalSkill, String ID, String firstName, String lastName, String address, String phone, String email, int type, int birthDate) {
        super(ID, firstName, lastName, address, phone, email, type, birthDate);
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    // Getter and setter methods for class attributes
    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }
    
    // Method to create a new Experience candidate
    public void createExperience(ArrayList <Candidate> lc){
        System.out.println("===========EXPERIENCE CANDIDATE============");
        super.createCandidate(lc); // Call the createCandidate method of the super class (Candidate)
        setType(0); // Set the type of candidate (0 for Experience)
        System.out.print("Professional skill: ");
        this.setProfessionalSkill(inputHandle.inputStringWithoutNumbers());
        System.out.print("Experience years: ");
        this.setYearExperience(inputHandle.inputExperience(getBirthDate())); // Calculate and set experience years
    }
}
