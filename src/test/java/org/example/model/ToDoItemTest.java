package org.example.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ToDoItemTest {
    LocalDate localDate = LocalDate.parse("2021-11-07");
    Person testPerson = new Person(7, "First", "Last", "first.last@gmail.com");
    ToDoItem test = new ToDoItem(1, "title", "Just a title", localDate, true, testPerson);

    @Test
    public void getId() {
        int expected = 1;

        assertEquals(expected, test.getId());
    }

    @Test
    public void setId() {
        int expected = 11;
        test.setId(expected);

        assertEquals(expected, test.getId());
    }

    @Test
    public void getTitle() {
        String expected = "title";

        assertEquals(expected, test.getTitle());
    }

    @Test
    public void setTitle() {
        String expected = "Title II";
        test.setTitle(expected);

        assertEquals(expected, test.getTitle());
    }

    @Test
    public void getTaskDescription() {
        String expected = "Just a title";

        assertEquals(expected, test.getTaskDescription());
    }

    @Test
    public void setTaskDescription() {
        String expected = "The sequel...";
        test.setTaskDescription(expected);

        assertEquals(expected, test.getTaskDescription());
    }

    @Test
    public void getDeadLine() {
        LocalDate expected = LocalDate.parse("2021-11-07");

        assertEquals(expected, test.getDeadLine());
    }

    @Test
    public void setDeadLine() {
        LocalDate expected = LocalDate.parse("1979-04-10");
        test.setDeadLine(expected);

        assertEquals(expected, test.getDeadLine());
    }

    @Test
    public void isDone() {
        assertTrue(test.isDone());
    }

    @Test
    public void setDone() {
        test.setDone(false);

        assertFalse(test.isDone());
    }

    @Test
    public void getPerson() {
        String testFirst = "First";
        String testLast = "Last";
        String testEmail = "first.last@gmail.com";

        assertEquals(testFirst, testPerson.getFirstName());
        assertEquals(testLast, testPerson.getLastName());
        assertEquals(testEmail, testPerson.getEmail());
    }

    @Test
    public void setPerson() {
        String testFirst = "Fina";
        testPerson.setFirstName(testFirst);

        String testLast = "Lana";
        testPerson.setLastName(testLast);

        String testEmail = "fina.lana@gmail.com";
        testPerson.setEmail(testEmail);

        assertEquals(testFirst, testPerson.getFirstName());
        assertEquals(testLast, testPerson.getLastName());
        assertEquals(testEmail, testPerson.getEmail());
    }
}