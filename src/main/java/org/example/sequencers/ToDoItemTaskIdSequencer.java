package org.example.sequencers;

public class ToDoItemTaskIdSequencer {
    private static int currentId;

    public static int nextId() {
        return currentId++;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        ToDoItemTaskIdSequencer.currentId = currentId;
    }
}
