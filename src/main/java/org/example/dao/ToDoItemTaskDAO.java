package org.example.dao;

import org.example.model.ToDoItemTask;

import java.util.Collection;

public interface ToDoItemTaskDAO {
    ToDoItemTask persist(ToDoItemTask toDoItemTask);
    ToDoItemTask findById(int id);
    Collection<ToDoItemTask> findAll();
    Collection<ToDoItemTask> findAssignedStatus(boolean status);
    Collection<ToDoItemTask> findByPersonId(int personId);
    void remove(int id);
}
