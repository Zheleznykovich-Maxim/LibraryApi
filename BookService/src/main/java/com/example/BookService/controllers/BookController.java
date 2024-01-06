package com.example.BookService.controllers;

import com.example.BookService.models.Book;
import com.example.BookService.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String findAll(Model model) {
        List<Book> books = (List<Book>) bookService.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    @PostMapping("/book-create")
    public String createBook(Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book-find-id")
    public String findBookById(@Param("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("books", book);
        model.addAttribute("id", id);
        return "index";
    }

    @GetMapping("/book-find-isbn")
    public String findBookByISBN(@Param("isbn") String isbn, Model model) {
        List<Book> books = (List<Book>) bookService.findByISBN(isbn);
        model.addAttribute("books", books);
        model.addAttribute("isbn", isbn);
        return "index";
    }
}

