package com.chf.example.apache.axonframework;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class ToDoItem extends AbstractAnnotatedAggregateRoot<String> {

    private static final long serialVersionUID = 1L;

    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(CreateToDoItemCommand command) {
        apply(new ToDoItemCreatedEvent(command.getTodoId(),
                command.getDescription()));
    }

    @CommandHandler
    public void markCompleted(MarkCompletedCommand command) {
        apply(new ToDoItemCompletedEvent(id));
    }

    @EventHandler
    public void on(ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
    }

}
