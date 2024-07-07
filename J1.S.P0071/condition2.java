public int addTask(ArrayList<Task> TaskList, int id) {
    System.out.println("----------------Add Task------------------");
    String requirementName = getdata.getString("Requirement Name: ", "Requirement name should not contain special characters or numbers.", "[a-zA-Z\\s]+");
    String taskType = getdata.GetTaskType("Task Type: ");
    String date = getdata.getDate("Date: ");
    double planFrom = getdata.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
    double planTo = getdata.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
    String Assignee = "";
    String reviewer = "";
    boolean isExist = false;

    do {
        // Nhập dữ liệu cho Assignee và Reviewer
        String[] assigneeAndReviewer = getAssigneeAndReviewer();
        Assignee = assigneeAndReviewer[0];
        reviewer = assigneeAndReviewer[1];

        // Kiểm tra xem Assignee và Reviewer có giống nhau không
        if (Assignee.equals(reviewer)) {
            System.out.println("Assignee and Reviewer cannot be the same. Please enter again.");
            isExist = true;
        } else {
            isExist = checkDuplicate(date, Assignee, planFrom, planTo, TaskList);
            if (isExist) {
                System.out.println("Duplicate!!!");
            } else {
                Task newTask = new Task(id, taskType, requirementName, date, planFrom, planTo, Assignee, reviewer);
                TaskList.add(newTask);
                id++;
                System.out.println("Add successful!!");
            }
        }
    } while (isExist);

    return id;
}

// Phương thức để nhập dữ liệu cho Assignee và Reviewer
private String[] getAssigneeAndReviewer() {
    String[] assigneeAndReviewer = new String[2];
    assigneeAndReviewer[0] = getdata.getString("Assignee: ", "Assignee should not contain special characters or numbers.", "[a-zA-Z\\s]+");
    assigneeAndReviewer[1] = getdata.getString("Reviewer: ", "Reviewer should not contain special characters or numbers.", "[a-zA-Z\\s]+");
    return assigneeAndReviewer;
}
