import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class represents a manager for the candidate management system.
 */
public class Manager {
    /**
     * Displays the menu options for the candidate management system.
     * @return The user's choice from the menu.
     */
    public int menu(){
        // Displaying the menu options
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        // Taking user input for choice
        int choice = inputHandle.inputNumberInRange(1, 5, "Please input a number between 1 and 5");
        return choice;
    }
    
    /**
     * Searches for a candidate by name and type.
     * @param listCandi The list of candidates to search from.
     */
    public void searchCandidate(ArrayList <Candidate> listCandi){
        // Prompting the user to input candidate name and type
        System.out.println("=====Search=====");
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = inputHandle.inputString();
        System.out.print("Input type of candidate: ");
        // Validating user input for candidate type
        int type = inputHandle.inputNumberInRange(0, 2, "You must input a number between 0 and 2");
        boolean search = false;
        // Check if type, first name, and last name matched
        for (Candidate candidate : listCandi) {
            if(type == candidate.getType() 
                    && (candidate.getFirstName().toLowerCase().contains(name.toLowerCase().trim())
                    || candidate.getLastName().toLowerCase().contains(name.toLowerCase().trim()))){
                // Displaying found candidate(s)
                System.out.println("The candidates found: ");
                System.out.println(candidate.toString());
                search = true;
            }
        }
        // Displaying a message if no candidate found
        if(!search){
            System.out.println("\nNo candidates found!");
        }
    }
    
    /**
     * Prints the list of candidates categorized by their type.
     * @param listCandi The list of candidates to print.
     */
    public void printList(ArrayList <Candidate> listCandi){
        // Displaying the list of candidates categorized by type
        System.out.println("List of candidates: ");
        System.out.println("===========EXPERIENCE CANDIDATES============");
        // Printing experience candidates
        for (Candidate candidate : listCandi) {
            if(candidate instanceof Experience){
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        
        System.out.println("===========FRESHER CANDIDATES==============");
        // Printing fresher candidates
        for (Candidate candidate : listCandi) {
            if(candidate instanceof Fresher){
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        
        System.out.println("===========INTERN CANDIDATES==============");
        // Printing intern candidates
        for (Candidate candidate : listCandi) {
            if(candidate instanceof Internship){
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}
