package com.chf.example.apache.axonframework;

import java.io.File;
import java.util.UUID;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;

public class Main {

    public static void main(String[] args) {
        CommandBus commandBus = new SimpleCommandBus();

        CommandGateway commandGateway = new DefaultCommandGateway(commandBus);

        EventStore eventStore = new FileSystemEventStore(
                new SimpleEventFileResolver(new File("./events")));

        EventBus eventBus = new SimpleEventBus();

        EventSourcingRepository<ToDoItem> repository = new EventSourcingRepository<>(
                ToDoItem.class, eventStore);
        repository.setEventBus(eventBus);

        AggregateAnnotationCommandHandler.subscribe(ToDoItem.class, repository,
                commandBus);
        AnnotationEventListenerAdapter.subscribe(new ToDoEventHandler(),
                eventBus);

        final String itemId = UUID.randomUUID().toString();
        commandGateway
                .send(new CreateToDoItemCommand(itemId, "Need to do this"));
        commandGateway.send(new MarkCompletedCommand(itemId));
    }

}
