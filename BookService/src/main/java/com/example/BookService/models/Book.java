package com.example.BookService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 13)
    @Pattern(regexp="[\\d]{13}")
    @Column(name = "isbn", length = 13, unique = true)
    private String isbn;
    @Column(name = "title", length = 30)
    private String title;
    @Column(name = "genre", length = 20)
    private String genre;
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "author", length = 20)
    private String author;

}

