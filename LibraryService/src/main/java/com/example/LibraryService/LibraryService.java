package com.example.LibraryService;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public void save(int bookId) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime dateInTwoWeeks = currentDate.plusWeeks(2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedCurrentDate = currentDate.format(formatter);
        String formattedDateInTwoWeeks = dateInTwoWeeks.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedCurrentDate, formatter);
        libraryRepository.save(
                Library.builder()
                        .bookId(bookId)
                        .tookBook(dateTime)
                        .returnBook(formattedDateInTwoWeeks)
                        .build()
        );
    }
}
