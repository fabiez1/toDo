package org.example.data;

import org.example.data.interfaces.PersonDAO;
import org.example.io.JSONManager;
import org.example.model.Person;

import java.io.File;
import java.util.*;

public class PersonDAOCollection implements PersonDAO {
    public static PersonDAOCollection INSTANCE;

    private PersonDAOCollection(Collection<Person> people) {
        this.people = people == null ? new HashSet<>(JSONManager.getInstance().deserializeFromJSON(new File("src/main/java/resources.properties/persons.json"), Person.class)) : new HashSet<>(people);
    }

    public static PersonDAO getInstance() {
        if(INSTANCE == null) INSTANCE = new PersonDAOCollection(null);
        return INSTANCE;
    }

    static PersonDAOCollection getTestInstance(Collection<Person> people) {
        if(people == null) people = new ArrayList<>();
        return new PersonDAOCollection(people);
    }

    private final Set<Person> people;

    @Override
    public Person persist(Person person) {
        boolean isSaved = people.add(person);
        if(isSaved) {
            return person;
        }
        return null;
    }

    @Override
    public Person findById(int id) {
        for(Person person : people) {
            if(person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for(Person person : people) {
            if(person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return people;
    }

    @Override
    public void remove(Person id) {
        people.remove(id);
    }
}
