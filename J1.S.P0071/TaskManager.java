/*
 * This class manages tasks and provides methods for adding, deleting, and displaying tasks.
 */
package pkg71;

import java.util.ArrayList;

/*
 * This class manages tasks and provides methods for adding, deleting, and displaying tasks.
 */
public class TaskManager extends ArrayList<Task> {

    // Create instances of GetData and Display classes for user input and output
    final GetData getdata = new GetData();
    final Display display = new Display();

    // Method to add a new task to the task list
    public int addTask(ArrayList<Task> taskList, int id) {
        // Prompt the user to input task details
        System.out.println("----------------Add Task------------------");
        String requirementName = getdata.getString("Requirement Name: ", "", "");
        String taskType = getdata.getTaskType("Task Type: ");
        String date = getdata.getDate("Date: ");
        double planFrom = getdata.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
        double planTo = getdata.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
        String assignee = getdata.getString("Assignee: ", "", "");
        String reviewer = getdata.getString("Reviewer: ", "", "");
        // Check for duplicate tasks
        boolean isExist = checkDuplicate(date, assignee, planFrom, planTo, taskList);
        // If the task is not a duplicate, add it to the task list
        if (!isExist) {
            Task newTask = new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer);
            taskList.add(newTask);
            id++;
            System.out.println("Add successful!!");
        } else {
            System.out.println("Duplicate!!!");
        }
        return id;
    }

    // Method to check for duplicate tasks
    boolean checkDuplicate(String date, String assignee, double planFrom, double planTo, ArrayList<Task> taskList) {
        boolean isExist = false;
        // Iterate through the task list to check for duplicates
        for (Task task : taskList) {
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                if ((planTo < task.getPlanFrom()) || (planFrom > task.getPlanTo())) {
                    isExist = false;
                } else {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    // Method to delete a task from the task list
    void deleteTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else {
            System.out.println("-------Del Task---------");
            int indexInList = -1;
            int taskId = getdata.getInt("ID: ", "Task id is out of range!", 1, Integer.MAX_VALUE);
            for (Task task : taskList) {
                if (taskId == task.getTaskID()) {
                    indexInList = taskList.indexOf(task);
                }
            }
            if(indexInList != -1){
                taskList.remove(indexInList);
                System.out.println("Delete successful!");
            } else {
                System.out.println("Id is not exist!");
            }
        }
    }

    // Method to display all tasks in the task list
    public void getDataTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else {
            System.out.println("----------------------------Task-------------------------------------");
            System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }
}
