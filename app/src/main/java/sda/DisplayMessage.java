package sda;

/**
 * This is a DisplayMessage class
 * it contains all messages to be display
 *
 * @author Hailu
 * @version 1.0
 * @since 2021-03-05
 **/
public class DisplayMessage {

    // A public constant field,
    // it holds the code to Reset any text font color
    public static final String ResetText = "\u001B[0m";

    // A public constant field,
    // it holds the code to change text font color to Red
    public static final String RedText = "\u001B[31m";

    // A public constant field,
    // it holds the code to change text font color to Green
    public static final String GreenText = "\u001B[32m";

    /**
     *
     * This method will display the display page on standard output/terminal
     * to display all options for user selection.
     * @param uncompletedTask takes the number of incomplete tasks (int) to show in display page
     * @param completedTask takes the number of complete tasks (int) to show in display page
     */
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

    /**
     * This method displays the menu to standard output/terminal
     * to show the options to display all tasks for user selection
     */
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

    /**
     * This method will display a prompt to user
     * for typing the task number to EDIT
     */
    public static void editTaskOptions () {
        System.out.println(GreenText);
        System.out.println(">> Type a task number to EDIT, then press ENTER key: ");
        System.out.println(ResetText);
    }

    /**
     * This method will display the Edit menu options on standard output/terminal
     * for user selection
     */
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

    /**
     * This method will display the Good bye message
     * while ending the program
     */
    public static void greetingMessage () {
        System.out.println(GreenText);
        System.out.println(">> All tasks are saved to data file");
        System.out.println(">> Good bye, for now!");
        System.out.println(ResetText);
    }

    /**
     * This method will display the error message if a user input an option which is not
     * from the choices given in main page
     */
    public static void errorMessage () {
        System.out.println(RedText);
        System.out.println(">> Incorrect number: Please enter a number from the given choices ");
        System.out.print(ResetText);
    }

    /**
     * This message will display any given message in Red or Green text on standard output/terminal
     * @param message a text message as String
     * @param warning a boolean value, true for printing warning with Red text, and false
     *                for printing message in Green text on standard output/terminal
     */
    public static void showMessage(String message, boolean warning) {
        System.out.println(warning?RedText:GreenText);
        System.out.println(">> " + message);
        System.out.println(ResetText);
    }

    /**
     * This message will print the given character on standard output/terminal
     * to given number of times
     * @param charToPrint a character given in single quote to print, i.e., '='
     * @param times an integer to repeat printing the given character
     */
    public static void separator (char charToPrint, int times) {
        for (int index=0; index<times; index++)
            System.out.print(charToPrint);
        System.out.println("");
    }

}
