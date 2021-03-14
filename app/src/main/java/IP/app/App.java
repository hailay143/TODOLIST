package IP.app;

import java.util.Scanner;

/**
 * This is the main class for the project
 *
 * @author Hailu
 * @version 1.0
 * @since 2021-03-05
 **/
public class App {

    // This a string to hold the data file name.
    // The file name contains all tasks and related details
    public static String fileName = "TaskList.obj"; // Holds the task list file with txt format

    /**
     * The main method to run the command line based "To Do List" application
     * @param args array of String holding command line parameters
     */
    public static void main(String[] args) {

        // Create an object of TaskListing/todolist
        // It holds all tasks
        TaskListing todolist = new TaskListing();
        //Create a string that will hold the user choice entered
        String selectMenu = "-21";
        try {
            // Take the data file as an input
            Scanner input = new Scanner(System.in);
            //It reads the data from the task list data file
            //However, if this is the first time the Application running,
            // a message will be shown, ""The data file, i.e. 'fileName does not exists"
            todolist.readFromFile(fileName);
            //Display the welcome message
            DisplayMessage.showMessage("Welcome to ToDoLy", false);
            while (!selectMenu.equals("4")) {
                DisplayMessage.displayPage(todolist.notCompletedCount(), todolist.completedCount());
                selectMenu = input.nextLine();

                switch (selectMenu) {
                    case "1":
                        DisplayMessage.listOfAllTasks();
                        todolist.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        todolist.readTask();
                        break;
                    case "3":
                        todolist.listAllTasksByIndex();
                        DisplayMessage.editTaskOptions();
                        todolist.editTask(input.nextLine());
                        break;
                    case "4":
                        break;
                    default:
                        DisplayMessage.errorMessage();
                }
            }

            // saving the updated task to the data file
            // if this is the first time, a new task file will be created (E.g. TaskList.obj)
            todolist.saveToFile(fileName);
            DisplayMessage.greetingMessage();

        } catch (Exception e) {
            DisplayMessage.showMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            todolist.saveToFile(fileName);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace()); // check it up

        }
    }
}