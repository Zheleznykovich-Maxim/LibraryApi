package com.example.LibraryService;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

//    @GetMapping("library-book/{bookId}")
//    public void CreateLibraryBook(@PathVariable int bookId) {
//        libraryService.save(bookId);
//    }
}
