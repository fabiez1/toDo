package org.example.model;

public class ToDoItemTask {
    private int id;
    private boolean assigned;
    private ToDoItem toDoItem;
    private Person assignee;

    public ToDoItemTask(int id, boolean assigned, ToDoItem toDoItem, Person assignee) {
        this.id = id;
        setAssigned(assigned);
        setToDoItem(toDoItem);
        setAssignee(assignee);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}
