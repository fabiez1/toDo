package org.example.data;

import org.example.data.interfaces.ToDoItemDAO;
import org.example.io.JSONManager;
import org.example.model.ToDoItem;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoItemDAOCollection implements ToDoItemDAO {
    public static ToDoItemDAOCollection INSTANCE;

    private ToDoItemDAOCollection(Collection<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems == null ? new HashSet<>(JSONManager.getInstance().deserializeFromJSON(new File("src/main/java/resources.properties/todoitems.json"), ToDoItem.class)) : new HashSet<>(toDoItems);
    }

    public static ToDoItemDAO getInstance() {
        if(INSTANCE == null) INSTANCE = new ToDoItemDAOCollection(null);
        return INSTANCE;
    }

    static ToDoItemDAOCollection getTestInstance(Collection<ToDoItem> toDoItems) {
        if(toDoItems == null) toDoItems = new ArrayList<>();
        return new ToDoItemDAOCollection(toDoItems);
    }

    private final Set<ToDoItem> toDoItems;

    @Override
    public ToDoItem persist(ToDoItem toDoItem) {
        boolean isSaved = toDoItems.add(toDoItem);
        if(isSaved) {
            return toDoItem;
        }
        return null;
    }

    @Override
    public ToDoItem findById(int id) {
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.getId() == id) {
                return toDoItem;
            }
        }
        return null;
    }

    @Override
    public Collection<ToDoItem> findAll() {
        return toDoItems;
    }

    @Override
    public Collection<ToDoItem> findByDoneStatus(boolean done) {
        List<ToDoItem> result = new ArrayList<>();
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.isDone() == done) {
                result.add(toDoItem);
            }
        }
        return result;
    }

    @Override
    public Collection<ToDoItem> findByTitleContains(String title) {
        List<ToDoItem> result = new ArrayList<>();
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.getTitle().equals(title)) {
                toDoItems.add(toDoItem);
            }
        }
        return result;
    }

    @Override
    public Collection<ToDoItem> findByPersonId(int personId) {
        List<ToDoItem> result = new ArrayList<>();
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.getPerson().getId() == personId) {
                result.add(toDoItem);
            }
        }
        return result;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineBefore(LocalDate date) {
        List<ToDoItem> result = new ArrayList<>();
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.getDeadLine().isBefore(date)) {
                result.add(toDoItem);
            }
        }
        return result;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineAfter(LocalDate date) {
        List<ToDoItem> result = new ArrayList<>();
        for(ToDoItem toDoItem : toDoItems) {
            if(toDoItem.getDeadLine().isAfter(date)) {
                result.add(toDoItem);
            }
        }
        return result;
    }

    @Override
    public void remove(ToDoItem id) {
        toDoItems.remove(id);
    }
}
