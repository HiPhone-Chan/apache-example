package com.chf.example.apache.axonframework;

public class ToDoItemCreatedEvent {

    private final String todoId;

    private final String description;

    public ToDoItemCreatedEvent(String todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}
