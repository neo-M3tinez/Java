# validate class 

    // Method to check the validity of an ID
        public static boolean isValidID(String ID) {
            // Check if the ID contains non-digit characters
            if (!ID.matches("\\d+")) {
                return false;
            }
        
        // Convert the ID to an integer to check if it's greater than or equal to 1
        int idNumber = Integer.parseInt(ID);
        return idNumber >= 1;
    }


      public static boolean checkID(ArrayList<Candidate> lc, String ID) {
            for (Candidate candidate : lc) {
                if (ID.equalsIgnoreCase(candidate.getID())) {
                    return false;
                }
            }
            return true;
        }

    // Method to input ID, check validity and uniqueness
    public static String inputID(ArrayList<Candidate> lc) {
        while (true) {
            String input = inputString();
            // Check the validity of the ID
            if (!isValidID(input)) {
                System.out.println("Invalid ID. ID must be a number greater than or equal to 1.");
                System.out.print("Enter again: ");
            }
            // Check the uniqueness of the ID
            else if (!checkID(lc, input)) {
                System.out.println("ID duplicated!!!");
                System.out.print("ID: ");
            } else {
                return input;
            }
        }
    }
}
