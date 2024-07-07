String getString(String msg, String formatMsg, String regex) {
    String input;
    do {
        System.out.print(msg);
        input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("Input could not be empty!!!");
            continue;
        } else {
            if (regex.isEmpty()) {
                break;
            } else if (input.matches(regex)) {
                break;
            } else {
                System.out.println(formatMsg);
                continue;
            }
        }
    } while (true);
    return input;
}



public int addTask(ArrayList<Task> TaskList, int id) {
        System.out.println("----------------Add Task------------------");
        String requirementName = getdata.getString("Requirement Name: ", "Requirement name must be character", "[a-zA-Z\\s]+");
        String taskType = getdata.GetTaskType("Task Type: ");
        String date = getdata.getDate("Date: ");
        double planFrom = getdata.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
        double planTo = getdata.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
        String Assignee = getdata.getString("Assignee: ", "Assignee must be character", "[a-zA-Z\\s]+");
        String reviewer = getdata.getString("Reviewer: ", "Reviewer must be character", "[a-zA-Z\\s]+");
        boolean isExist = checkDuplicate(date, Assignee, planFrom, planTo, TaskList);
        //check value of variable isExist
        if (isExist) {
            System.out.println("Duplicate!!!");
        } else {
            Task newTask = new Task(id, taskType, requirementName, date, planFrom, planTo, Assignee, reviewer);
            TaskList.add(newTask);
            id++;
            System.out.println("Add successful!!");
        }
        return id;
    }



