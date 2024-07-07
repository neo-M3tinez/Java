import java.util.ArrayList;

/**
 * This class contains the main method to run the Candidate Management System.
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager(); // Creating a Manager instance
        ArrayList <Candidate> candidate = new ArrayList<>(); // Creating an ArrayList to store candidates
        while(true){
            int choice = m.menu(); // Displaying the menu and getting user's choice
            do{
                boolean go = false;
                switch(choice){
                    case 1:
                        // Creating an Experience candidate and adding it to the list
                        Experience e = new Experience();
                        e.createExperience(candidate);
                        candidate.add(e);
                        break;
                    case 2:
                        // Creating a Fresher candidate and adding it to the list
                        Fresher f = new Fresher();
                        f.createFresher(candidate);
                        candidate.add(f);
                        break;
                    case 3:
                        // Creating an Internship candidate and adding it to the list
                        Internship i = new Internship();
                        i.createInternship(candidate);
                        candidate.add(i);
                        break;
                    case 4:
                        // Printing the list of candidates, searching for a candidate, and giving the option to continue
                        m.printList(candidate);
                        m.searchCandidate(candidate);
                        go = true;
                        break;
                    case 5:
                        return; // Exiting the program
                }
                if(go == false){
                    // Asking the user if they want to continue or not
                    if(!inputHandle.yesNo()){
                        m.printList(candidate);
                        break;
                    }
                }else{
                    break;
                }
            }while(true);
        }
    }
}
