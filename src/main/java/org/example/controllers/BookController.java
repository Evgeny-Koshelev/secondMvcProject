package org.example.controllers;

import org.example.entities.Book;
import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mvc")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getById(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Book());
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> delete(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Book());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.save(book));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Book());
        }
    }

    @PatchMapping("/change")
    public ResponseEntity<Book> change(@RequestBody Book users) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.update(users));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Book());
        }
    }
}
