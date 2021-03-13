package sda;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

public class Tasks implements Serializable {

    private String title;
    private String project;
    private boolean status;
    private LocalDate dueDate;

    public Tasks(String title, String project, LocalDate dueDate) {

        this.title=title;
        this.project=project;
        this.status=false;
        this.dueDate=dueDate;

    }

    public String getTitle() {
        return this.title;

    }

    public void setTitle(String title)
            throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Please enter title.");
        }
        this.title = title.trim();
    }

    public String getProject() {

        return this.project;
    }

    public void setProject(String project) {

        this.project = project.trim();
    }

    public boolean isComplete() {

        return this.status;
    }

    public boolean markInComplete() {

        this.status = false;
        return this.status;
    }

    public boolean markCompleted() {
        this.status = true;
        return this.status;
    }

    public LocalDate getDueDate() {

        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
            throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now()) < 0)    {
            throw new DateTimeException("Enter date manually");
        }

        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-mm");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    public String formattingTask() {
        return ( "\nTitle     : " + title +
                "\nProject : " + project +
                "\nStatus : " + (status?"Completed":"Not completed") +
                "\n Due Date : " + dueDate + "\n");
    }
}
