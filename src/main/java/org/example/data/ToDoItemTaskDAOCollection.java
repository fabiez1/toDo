package org.example.data;

import org.example.data.interfaces.ToDoItemTaskDAO;
import org.example.io.JSONManager;
import org.example.model.ToDoItem;
import org.example.model.ToDoItemTask;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoItemTaskDAOCollection implements ToDoItemTaskDAO {
    public static ToDoItemTaskDAOCollection INSTANCE;

    private ToDoItemTaskDAOCollection(Collection<ToDoItemTask> toDoItemTasks) {
        this.toDoItemTasks = toDoItemTasks == null ? new HashSet<>(JSONManager.getInstance().deserializeFromJSON(new File("src/main/java/resources.properties/todoitemtasks.json"), ToDoItemTask.class)) : new HashSet<>(toDoItemTasks);
    }

    public static ToDoItemTaskDAO getInstance() {
        if(INSTANCE == null) INSTANCE = new ToDoItemTaskDAOCollection(null);
        return INSTANCE;
    }

    static ToDoItemTaskDAOCollection getTestInstance(Collection<ToDoItemTask> toDoItemTasks) {
        if(toDoItemTasks == null) toDoItemTasks = new ArrayList<>();
        return new ToDoItemTaskDAOCollection(toDoItemTasks);
    }

    private final Set<ToDoItemTask> toDoItemTasks;

    @Override
    public ToDoItemTask persist(ToDoItemTask toDoItemTask) {
        boolean isSaved = toDoItemTasks.add(toDoItemTask);
        if(isSaved) {
            return toDoItemTask;
        }
        return null;
    }

    @Override
    public ToDoItemTask findById(int id) {
        for(ToDoItemTask toDoItemTask : toDoItemTasks) {
            if(toDoItemTask.getId() == id) {
                return toDoItemTask;
            }
        }
        return null;
    }

    @Override
    public Collection<ToDoItemTask> findAll() {
        return toDoItemTasks;
    }

    @Override
    public Collection<ToDoItemTask> findAssignedStatus(boolean status) {
        List<ToDoItemTask> result = new ArrayList<>();
        return result.stream()
                .filter(toDoItemTask -> toDoItemTask.getAssignee().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ToDoItemTask> findByPersonId(int personId) {
        List<ToDoItemTask> result = new ArrayList<>();
        for(ToDoItemTask toDoItemTask : toDoItemTasks) {
            if(toDoItemTask.getAssignee().getId() == personId) {
                result.add(toDoItemTask);
            }
        }
        return result;
    }

    @Override
    public void remove(ToDoItemTask id) {
        toDoItemTasks.remove(id);
    }
}
