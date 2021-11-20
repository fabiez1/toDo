package org.example.data.interfaces;

import org.example.model.Person;

import java.util.Collection;

public interface PersonDAO {
    Person persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(Person id);
}
