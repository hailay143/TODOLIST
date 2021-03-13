
package sda;

import java.util.Scanner;

public class Main {

    public static String fileName = "TaskList.obj"; // Holds the task list file with txt format

    public static void main(String[] args) {

        TaskListing todolist = new TaskListing();
        String selectMenu = "-17";


        try {
            Scanner input = new Scanner(System.in);
            todolist.readFromFile(fileName);

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

            todolist.saveToFile(fileName);
            DisplayMessage.greetingMessage();

        } catch (Exception e) {
            DisplayMessage.showMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            todolist.saveToFile(fileName);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}


