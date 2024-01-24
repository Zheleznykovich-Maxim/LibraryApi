package com.example.BookService.services;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service

@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) {
        bookRepository.saveAndFlush(book);
//        restTemplate.getForObject(
//                "http://LibraryService/library-book/{bookId}",
//                Book.class,
//                book.getId()
//        );
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public Iterable<Book> findByISBN(String isbn) {
        return bookRepository.findByisbnContaining(isbn);
    }
}
