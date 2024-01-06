package com.example.BookService.repositories;

import com.example.BookService.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByisbn(String isbn);
    Iterable<Book> findByisbnContaining(String isbn);
}