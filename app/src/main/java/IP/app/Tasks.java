package IP.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

/**
 * This is a model class and it represents a Tasks object
 * and it contains necessary fields and methods to operate
 * on task object.
 *
 * @author  HAilu
 * @version 1.0
 * @since   2021-03-05
 **/
public class Tasks implements Serializable {

    // A String that holds the title of a task and it cannot be empty
    private String title;
    // A String that holds the name of project associated with task, and it could be an empty string
    private String project;
    // A boolean value, if true: the task is completed, otherwise false
    private boolean complete;
    // The due date of the task as yyyy-mm-dd format
    private LocalDate dueDate;

    /**
     * Creating an object of Tasks class
     * @param title A String that holds the title of a task and it cannot be empty or null.
     * @param project A String that holds the name of project associated with task, and it could be an empty string.
     * @param dueDate The due date of the task as yyyy-mm-dd format
     */
    public Tasks(String title, String project, LocalDate dueDate) {

        this.title=title;
        this.project=project;
        this.complete=false;
        this.dueDate=dueDate;
    }

    /**
     * A method to get the task title
     * @return a String containing the title of a task
     */
    public String getTitle() {
        return this.title;

    }

    /**
     * A method to set the title of a Task object
     * @param title A String that holds the title of a task and it cannot be empty or null.
     * @throws NullPointerException if title is null or empty string
     */
    public void setTitle(String title)
            throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Please enter title.");
        }
        this.title = title.trim();
    }

    /**
     * A method to get the project name
     * @return a String containing the project name
     */
    public String getProject() {
        return this.project;
    }

    /**
     * A method to set the project name
     * @param project A String that holds the name of project associated with task, and it could be an empty string.
     */
    public void setProject(String project) {
        this.project = project.trim();
    }

    /**
     * A method to get the completed status of task
     * @return true: if the task is marked as completed, otherwise it will return false
     */
    public boolean isComplete() {
        return this.complete;
    }

    /**
     * A method to mark a task as in complete
     * @return the updated value of the field complete
     */
    public boolean markInComplete() {
        this.complete = false;
        return this.complete;
    }

    /**
     * A method to mark a task as completed
     * @return the updated value of the field complete
     */
    public boolean markCompleted() {
        this.complete = true;
        return this.complete;
    }

    /**
     * A method to get the due date of the task
     * @return the due date of task as LocalDate object
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * A method to set the due date of a task
     * @param dueDate The due date of the task as yyyy-mm-dd format
     * @throws DateTimeException if given date is a past date
     */
    public void setDueDate(LocalDate dueDate)
            throws DateTimeException {
        // Throw DateTimeException if past date is given
        if (dueDate.compareTo(LocalDate.now()) < 0)    {
            throw new DateTimeException("Enter date manually");
        }
        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-mm");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /**
     * A method to get the task data as formatted string to display in multiple lines
     * @return formatted string of all fields of a task
     */
    public String formattingTask() {
        return ( "\nTitle     : " + title +
                "\nProject : " + project +
                "\nStatus : " + (complete?"Completed":"Not completed") +
                "\n Due Date : " + dueDate + "\n");
    }
}
