package org.example;

import org.example.model.AppRole;
import org.example.model.Person;

public class App
{
    public static void main( String[] args ) {
        Person fabz = new Person(2,
                "Jerry",
                "Rice",
                "jerryrice@nfl.com");

        fabz.getSummary();
        for(AppRole user : AppRole.values()) {
            System.out.println(user);
        }
    }
}
