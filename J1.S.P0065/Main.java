package j1.s.p0065;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a Manager object to manage student information
        Manager m = new Manager();
        // Create a list to store student objects
        List <Student> ls = new ArrayList<>();
        // Call methods to create and manage student information
        m.createStudent(ls);
        m.printStudent(ls);
        m.printPercentage(ls);
    }
}
