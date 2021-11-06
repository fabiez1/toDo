package org.example.model;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
    AppRole role;

    public AppUser(String username, String password, AppRole role) {
        if(username.equals(null) || username.equals("")) {
            throw new RuntimeException("Username was empty");
        } else if(password.equals(null) || password.equals("")) {
            throw new RuntimeException("Password was empty");
        } else if(role.equals(null) || role.equals("")) {
            throw new RuntimeException("Role was empty");
        }

        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}