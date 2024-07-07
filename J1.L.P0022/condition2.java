// Method for inputting a string from the user
    public static String inputString() {
        while (true) {
            String input = in.nextLine().trim();
            // Check if the string is empty or only contains whitespace
            if (input.isEmpty() || input.equals(" ")) {
                System.out.println("Empty!!!");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    // Method for inputting a string from the user without numbers
public static String inputStringWithoutNumbers() {
    while (true) {
        String input = in.nextLine().trim();
        // Check if the string is empty or only contains whitespace
        if (input.isEmpty() || input.equals(" ")) {
            System.out.println("Empty!!!");
            System.out.print("Enter again: ");
        } else if (!input.matches("[a-zA-Z]+")) {
            System.out.println("Name cannot contain numbers or special characters!");
            System.out.print("Enter again: ");
        } else {
            return input;
        }
    }
}
    

// Method for inputting an address from the user
public static String inputAddress() {
    while (true) {
        String input = in.nextLine().trim();
        // Check if the string is empty or only contains whitespace
        if (input.isEmpty() || input.equals(" ")) {
            System.out.println("Empty!!!");
            System.out.print("Enter again: ");
        } else if (Character.isDigit(input.charAt(0))) {
            System.out.println("Address cannot start with a number!");
            System.out.print("Enter again: ");
        } else {
            return input;
        }
    }
}

public static String inputEmail(ArrayList<Candidate> lc) {
        while (true) {
            String input = in.nextLine();
            // If the email address matches the regex pattern, return
            if (input.matches("[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$")) {
               boolean unique = true;
            // Check if the email address already exists
            for (Candidate candidate : lc) {
                if (input.equalsIgnoreCase(candidate.getEmail())) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                return input;
            } else {
                System.out.println("Email already exists! Please enter a different email.");
                System.out.print("Email: ");
            }
            } else {
                System.out.println("Email is string with format <account name>@<domain>.<domain>");
                System.out.print("Email: ");
            }
        }
    }

// Method for inputting graduation year
public static int inputGraduateDate(int birthDate) {
    // Calculate the year of university graduation based on birth date
    int graduationYear = calculateGraduationYear(birthDate);
    
    // Get the current year
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    
    while (true) {
        int graduateDate = inputNumberInRange(graduationYear, currentYear, "Graduate date must >= " + graduationYear);
        return graduateDate;
    }
}

// Method to calculate the year of university graduation based on the birth date
public static int calculateGraduationYear(int birthDate) {
    // Typically, the university graduation age is around 21 to 23 years old
    // You can adjust this based on your specific requirements
    int graduationAge = 22; // Assume the average graduation age is 22 years old
    
    // Calculate the graduation year by adding the birth year and graduation age
    int graduationYear = birthDate + graduationAge;
    
    return graduationYear;
}
