package org.example.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person test = new Person(3, "First", "Last", "first.last@gmail.com");
    AppUser testCredentials = new AppUser("Fila", "test123", AppRole.ROLE_APP_USER);

    @Test
    public void getId() {
        test.getId();
    }

    @Test
    public void getFirstName() {
        test.getFirstName();
    }

    @Test
    public void setFirstName() {
        String expected = "Fabbe";
        test.setFirstName(expected);

        assertEquals(expected, test.getFirstName());
    }

    @Test
    public void getLastName() {
        test.getLastName();
    }

    @Test
    public void setLastName() {
        String expected = "lala";
        test.setLastName(expected);

        assertEquals(expected, test.getLastName());
    }

    @Test
    public void getEmail() {
        test.getEmail();
    }

    @Test
    public void setEmail() {
        String expected = "bogus@gmail.com";
        test.setEmail(expected);

        assertEquals(expected, test.getEmail());
    }

    @Test
    public void getCredentials() {
        testCredentials.toString();
    }

    @Test
    public void setCredentials() {
        String testUser = "Firlas";
        testCredentials.setUsername(testUser);

        String testPass = "test123456";
        testCredentials.setPassword(testPass);

        AppRole testRole = AppRole.ROLE_APP_ADMIN;
        testCredentials.setRole(testRole);

        assertEquals(testUser, testCredentials.getUsername());
        assertEquals(testPass, testCredentials.getPassword());
        assertEquals(testRole, testCredentials.getRole());
    }
}