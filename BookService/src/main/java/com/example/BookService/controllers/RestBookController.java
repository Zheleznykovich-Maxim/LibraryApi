package com.example.BookService.controllers;

import com.example.BookService.config.MQConfig;
import com.example.BookService.models.Book;
import com.example.BookService.services.BookService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBookController {

    private final BookService bookService;
    @Autowired
    private RabbitTemplate template;

    @Autowired
    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book-create-rest")
    public String createRestBook(@RequestBody Book book) {
        bookService.createBook(book);
        template.convertAndSend(MQConfig.ROUTING_KEY, book.getId());
        return "Message ID was sent!";
    }
}
