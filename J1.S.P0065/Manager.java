package j1.s.p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    // Method to create student objects
    public void createStudent(List<Student> ls) {
        // Display program title
        System.out.println("====== Management Student Program ======");
        while (true) {
            // Prompt user for student's name
            System.out.print("Name: ");
            // Validate and input student's name
            String name = Validate.inputString("Name");
            // Prompt user for student's class
            System.out.print("Classes: ");
            // Validate and input student's class
            String classes = Validate.inputString("Classes");
            // Prompt user for student's Math score
            System.out.print("Maths: ");
            // Validate and input student's Math score
            int math = Validate.inputNumberInRange("Math");
            // Prompt user for student's Chemistry score
            System.out.print("Chemistry: ");
            // Validate and input student's Chemistry score
            int chemistry = Validate.inputNumberInRange("Chemistry");
            // Prompt user for student's Physics score
            System.out.print("Physics: ");
            // Validate and input student's Physics score
            int physics = Validate.inputNumberInRange("Physics");
            // Create a new Student object and add it to the list
            ls.add(new Student(name, classes, math, physics, chemistry));
            // Check if the user wants to enter more student information
            if (!Validate.yesNo()) {
                return;
            }
        }
    }

    // Method to print student information
    public void printStudent(List<Student> ls) {
        int count = 1;
        for (Student student : ls) {
            // Print student information
            System.out.println("------ Student " + count++ + " Info ------");
            System.out.println("Name: " + student.getName());
            System.out.println("Classes: " + student.getClassName());
            System.out.println("Average: " + student.getAverage());
            System.out.println("Type: " + student.getType());
        }
    }

    // Method to calculate the percentage of each classification type
    public HashMap<String, Double> getPercentage(List<Student> ls) {
        HashMap<String, Double> getPercentage = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        // Count the quantity of each classification type
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            } else if (ls.get(i).getType() == 'B') {
                typeB++;
            } else if (ls.get(i).getType() == 'C') {
                typeC++;
            } else {
                typeD++;
            }
        }
        // Calculate the percentage of each classification type
        getPercentage.put("A", typeA / totalStudent * 100);
        getPercentage.put("B", typeB / totalStudent * 100);
        getPercentage.put("C", typeC / totalStudent * 100);
        getPercentage.put("D", typeD / totalStudent * 100);
        return getPercentage;
    }

    // Method to print the percentage of each classification type
    public void printPercentage(List<Student> ls) {
        HashMap<String, Double> getPercentageStudent = getPercentage(ls);
        // Print the classification information
        System.out.println("-------- Classification Info -------");
        for (Map.Entry<String, Double> entry : getPercentageStudent.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + ": " + value + "%");
        }
    }
}
