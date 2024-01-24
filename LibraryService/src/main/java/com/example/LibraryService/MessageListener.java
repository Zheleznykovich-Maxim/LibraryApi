package com.example.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class MessageListener {
    private final LibraryService libraryService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(int id) {
        libraryService.save(id);
    }

}