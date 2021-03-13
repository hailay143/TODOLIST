package sda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
    Tasks task;

    String validTitle = "Test Title";
    String validProject="Test Project";
    LocalDate validDueDate=LocalDate.parse("2021-03-05");

    @BeforeEach
    public void setUp() throws Exception {
        try {
            task = new Tasks(validTitle, validProject, validDueDate);
        } catch (Exception e) {
            System.out.println("There are few errors in the testing of Task class");
            System.out.println("Following message could be helpful to identify the cause:");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testValidTitle() {
        assertEquals(validTitle,task.getTitle());
    }


    @Test
    public void testEmptyTitle() {
        boolean success=false;

        try {
            task.setTitle("");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }


    @Test
    public void testTrimEmptyTitle() {
        boolean success=false;

        try {
            task.setTitle("           ");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    @Test
    public void testNullTitle() {
        boolean success=false;

        try {
            task.setTitle(null);
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }


    @Test
    public void testValidProject() {
        assertEquals(validProject,task.getProject());
    }

    @Test
    public void testEmptyProject() {
        task.setProject("");assertEquals("",task.getProject());
    }

    @Test
    public void testValidDueDate() {

        assertEquals(validDueDate,task.getDueDate());
    }


    @Test
    public void testIncorrectFormatDueDate() {
        boolean success=false;

        try {
            task.setDueDate(LocalDate.parse("2021/03/12"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeParseException e) {
            success = true;
        }

        assertEquals(true,success);
    }


    @Test
    public void testPastDueDate() {
        boolean success=false;

        try {
            task.setDueDate(LocalDate.parse("2020-03-05"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeException e) {
            success = true;
        }

        assertEquals(true,success);
    }


}