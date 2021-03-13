package sda;

public class DisplayMessage {

    public static final String ResetText = "\u001B[0m";
    public static final String RedText = "\u001B[31m";
    public static final String GreenText = "\u001B[32m";

    public static void displayPage (int uncompletedTask, int completedTask ) {
        System.out.println("\n Main page");
        System.out.println("==============\n");
        System.out.println("You have " + DisplayMessage.RedText +
                uncompletedTask + " task(s) todo" +
                DisplayMessage.ResetText + " and " +
                DisplayMessage.GreenText + completedTask +
                " task(s) are done!\n" + DisplayMessage.ResetText);
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project) list");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove");
        System.out.println(">> (4) Save and Quit\n");
        System.out.println("Please enter your choice from [1-4]:");
    }

    public static void listOfAllTasks () {
        System.out.println("\n List of all tasks");
        System.out.println(" =====================\n");
        System.out.println("Select an option to list the tasks");
        System.out.println(" (1) Show task list by date" +
                DisplayMessage.RedText + " [default choice, just press ENTER key]"+
                DisplayMessage.ResetText);
        System.out.println(" (2) Show task list by project name");
        System.out.println("\nPlease enter your choice between [1 and 2]: ");
    }

    public static void editTaskOptions () {
        System.out.println(GreenText);
        System.out.println(">> Type a task number to edit, then press ENTER key");
        System.out.println(ResetText);
    }

    public static void editTaskList () {
        System.out.println("\nTask Edit Options");
        System.out.println("======================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Modify selected task");
        System.out.println("(2) Mark selected task as COMPLETED");
        System.out.println("(3) Delete selected task");
        System.out.println("(4) Return to main menu "
                + DisplayMessage.RedText + " [default choice, just press ENTER]" +
                DisplayMessage.ResetText);
        System.out.print("\nPlease enter your choice [1-4]: ");
    }

    public static void greetingMessage () {
        System.out.println(GreenText);
        System.out.println(">> All tasks are saved to data file");
        System.out.println(">> Good bye, for now!");
        System.out.println(ResetText);
    }

    public static void errorMessage () {
        System.out.println(RedText);
        System.out.println(">> Incorrect number: Please enter a number from the given choices ");
        System.out.print(ResetText);
    }

    public static void showMessage(String message, boolean warning) {
        System.out.println(warning?RedText:GreenText);
        System.out.println(">> " + message);
        System.out.println(ResetText);
    }

    public static void separator (char charToPrint, int times) {
        for (int index=0; index<times; index++)
            System.out.print(charToPrint);
        System.out.println("");
    }

}
