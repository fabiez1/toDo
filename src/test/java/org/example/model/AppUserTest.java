package org.example.model;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppUserTest {

    private AppUser appUser;

    @Before
    public void setUp() {
        appUser = new AppUser("fabz", "fabzfabz", AppRole.ROLE_APP_USER);
    }

    @Test
    public void getUsername() {
        String expected = "fabz";

        assertEquals(expected, appUser.getUsername());
    }

    @Test
    public void setUsername() {
        String data = "fabbe";
        appUser.setUsername(data);

        String expected = data;

        assertEquals(expected, appUser.getUsername());
    }

    @Test
    public void getPassword() {
        String expected = "fabzfabz";

        assertEquals(expected, appUser.getPassword());
    }

    @Test
    public void setPassword() {
        String expected = "fabbefabbe";
        appUser.setPassword(expected);

        assertEquals(expected, appUser.getPassword());
    }

    @Test
    public void getRole() {
        appUser.getRole();
    }

    @Test
    public void setRole() {
        AppRole role = AppRole.ROLE_APP_ADMIN;
        AppRole expected = role;
        appUser.setRole(role);

        assertEquals(expected, appUser.getRole());
    }
}