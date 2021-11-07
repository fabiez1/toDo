package org.example.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ToDoItemTaskTest {
    LocalDate localDate = LocalDate.parse("2021-11-07");
    Person testPerson = new Person(7, "First", "Last", "first.last@gmail.com");
    ToDoItem testItem = new ToDoItem(11, "Title", "Just a title", localDate, true, testPerson);
    ToDoItemTask testTask = new ToDoItemTask(1, true, testItem, testPerson);

    @Test
    public void getId() {
        int expected = 1;

        assertEquals(expected, testTask.getId());
    }

    @Test
    public void setId() {
        int expected = 27;
        testTask.setId(expected);

        assertEquals(expected, testTask.getId());
    }

    @Test
    public void isAssigned() {
        assertTrue(testTask.isAssigned());
    }

    @Test
    public void setAssigned() {
        testTask.setAssigned(false);

        assertFalse(testTask.isAssigned());
    }

    @Test
    public void getToDoItem() {
        int toDoItemId = 11;
        String toDoItemTitle = "Title";
        String toDoItemTaskDescription = "Just a title";
        LocalDate toDoItemDeadline = LocalDate.parse("2021-11-07");

        int personId = 7;
        String personFirstName = "First";
        String personLastName = "Last";
        String personEmail = "first.last@gmail.com";

        assertEquals(toDoItemId, testItem.getId());
        assertEquals(toDoItemTitle, testItem.getTitle());
        assertEquals(toDoItemTaskDescription, testItem.getTaskDescription());
        assertEquals(toDoItemDeadline, testItem.getDeadLine());
        assertTrue(testItem.isDone());

        assertEquals(personId, testPerson.getId());
        assertEquals(personFirstName, testPerson.getFirstName());
        assertEquals(personLastName, testPerson.getLastName());
        assertEquals(personEmail, testPerson.getEmail());
    }

    @Test
    public void setToDoItem() {
        int toDoItemId = 30;
        testItem.setId(toDoItemId);
        String toDoItemTitle = "Title II";
        testItem.setTitle(toDoItemTitle);
        String toDoItemTaskDescription = "The sequel...";
        testItem.setTaskDescription(toDoItemTaskDescription);
        LocalDate toDoItemDeadline = LocalDate.parse("1979-04-10");
        testItem.setDeadLine(toDoItemDeadline);

        String personFirstName = "FirstName";
        testPerson.setFirstName(personFirstName);
        String personLastName = "LastName";
        testPerson.setLastName(personLastName);
        String personEmail = "firstname.lastname@gmail.com";
        testPerson.setEmail(personEmail);

        assertEquals(toDoItemId, testItem.getId());
        assertEquals(toDoItemTitle, testItem.getTitle());
        assertEquals(toDoItemTaskDescription, testItem.getTaskDescription());
        assertEquals(toDoItemDeadline, testItem.getDeadLine());
        assertTrue(testItem.isDone());

        assertEquals(personFirstName, testPerson.getFirstName());
        assertEquals(personLastName, testPerson.getLastName());
        assertEquals(personEmail, testPerson.getEmail());
    }

    @Test
    public void getAssignee() {
        // Person is already being tested
    }

    @Test
    public void setAssignee() {
        // Person is already being tested
    }
}