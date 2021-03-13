package sda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskListing {

    private ArrayList<Tasks> taskList; // Array list of task object


    public TaskListing() {

        taskList = new ArrayList<>(); // taskList object
    }

    public void addTask(String title, String project, LocalDate dueDate) {
        this.taskList.add(new Tasks(title,project,dueDate)); // Adding task object to the array
    }

    public boolean readTask() {
        Scanner scan = new Scanner(System.in); // Read input from the user

        try {
            System.out.println(DisplayMessage.GreenText +
                    "Please enter the following details to add a task:" +
                    DisplayMessage.ResetText);
            System.out.print(">> Task Title  : ");
            String title = scan.nextLine();
            System.out.print(">> Project Name: ");
            String project = scan.nextLine();
            System.out.print(">> Due Date [For example: 2021-03-05] : ");
            LocalDate dueDate = LocalDate.parse(scan.nextLine());

            this.taskList.add(new Tasks(title,project,dueDate));
            DisplayMessage.showMessage("Task is added successfully", false);

            return true;
        } catch (Exception e) {
            DisplayMessage.showMessage(e.getMessage(),true);
            return false;
        }

    }

    public boolean readTaskUpdate(Tasks task) {
        Scanner scan = new Scanner(System.in);
        boolean isTaskUpdated = false;

        try {
            System.out.println(DisplayMessage.GreenText +
                    "Please enter the following details to update a task:"
                    + "\nIf you do not want to change any field, just press ENTER key!" +
                    DisplayMessage.ResetText);
            System.out.print(">> Task Title  : ");
            String title = scan.nextLine();
            if (!(title.trim().equals("") || title == null)) {
                task.setTitle(title);
                isTaskUpdated = true;
            }

            System.out.print(">> Project Name: ");
            String project = scan.nextLine();
            if (!(project.trim().equals("") || project == null)) {
                task.setProject(project);
                isTaskUpdated = true;
            }

            System.out.print(">> Due Date [For example: 2021-03-05] : ");
            String dueDate = scan.nextLine();
            if (!(dueDate.trim().equals("") || dueDate == null)) {
                task.setDueDate(LocalDate.parse(dueDate));
                isTaskUpdated = true;
            }

            DisplayMessage.showMessage("Task is " +
                    (isTaskUpdated ? "updated successfully" : "NOT modified") +
                    ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            DisplayMessage.showMessage(e.getMessage(), true);
            return false;
        }
    }

    public void listAllTasksByIndex() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (taskList.size()>0) {
            System.out.println(String.format(displayFormat,"NUMBER","TITLE","PROJECT","DUE DATE","COMPLETED"));
            System.out.println(String.format(displayFormat,"======","=====","=======","========","========="));
        } else {
            System.out.println(DisplayMessage.RedText + "No tasks to show" +
                    DisplayMessage.ResetText);
        }

        taskList.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        taskList.indexOf(task)+1,
                        task.getTitle(),
                        task.getProject(),
                        task.getDueDate(),
                        (task.isComplete()?"YES":"NO")
                )));
    }


    public void listAllTasks(String sortBy) {
        DisplayMessage.separator('=',75);
        System.out.println(
                "Total Tasks = " + taskList.size() +
                        "\t\t (Completed = " + completedCount() + "\t\t" +
                        DisplayMessage.ResetText + " Not compeleted = " +
                        notCompletedCount() + DisplayMessage.ResetText + " )");
        DisplayMessage.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-10s %-10s";

            if (taskList.size()>0) {
                System.out.println(String.format(displayFormat,"PROJECT","TITLE","DUE DATE","COMPLETED"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));
            } else {
                System.out.println(DisplayMessage.RedText + "No tasks to show" +
                        DisplayMessage.ResetText);
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Tasks::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getTitle(),
                            task.getDueDate(),
                            (task.isComplete()?"YES":"NO")
                    )));
        } else {
            String displayFormat = "%-10s %-35s %-20s %-10s";

            if (taskList.size() > 0) {
                System.out.println(String.format(displayFormat,"DUE DATE","TITLE","PROJECT" , "COMPLETED"));
                System.out.println(String.format(displayFormat,"========","=====","=======" , "========="));
            } else {
                System.out.println(DisplayMessage.RedText +
                        "No tasks to show" + DisplayMessage.ResetText);
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Tasks::getDueDate))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDueDate(),
                            task.getTitle(),
                            task.getProject(),
                            (task.isComplete() ? "YES" : "NO")
                    )));
        }
    }

    public void editTask(String selectedTask) throws NullPointerException {
        try {
            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("EMPTY/NULL TASK NUM: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM NOT GIVEN FROM TASK LIST: " +
                        "Returning to Main Menu");
            }

            Tasks task = taskList.get(taskIndex);

            DisplayMessage.showMessage("Task Num " + selectedTask +
                    "  is selected:" + task.formattingTask(), false);

            DisplayMessage.editTaskList();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    readTaskUpdate(task);
                    break;
                case "2":
                    task.markCompleted();
                    DisplayMessage.showMessage("Task Num " +
                            selectedTask + " is marked as Completed: Returning to Main Menu", false);
                    break;
                case "3":
                    taskList.remove(task);
                    DisplayMessage.showMessage("Task Num " +
                            selectedTask + " is Deleted: Returning to Main Menu", true);
                    break;
                default:
                    DisplayMessage.showMessage("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            DisplayMessage.showMessage(e.getMessage(),true);
        }
    }


    public int completedCount() {
        return (int) taskList.stream()
                .filter(Tasks::isComplete)
                .count();
    }

    public int notCompletedCount() {
        return (int) taskList.stream()
                .filter(task -> !task.isComplete())
                .count();
    }

    public boolean readFromFile(String filename) {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                DisplayMessage.showMessage("The data file, i.e., " +
                        filename + " does not exists", true);
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ArrayList<Tasks>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            DisplayMessage.showMessage(e.getMessage(),true);
            return false;
        }
    }


    public boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            DisplayMessage.showMessage(e.getMessage(),true);
            return false;
        }
    }
}

