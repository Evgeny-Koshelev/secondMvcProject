package org.example.services;

import org.example.entities.Book;
import org.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getById(UUID id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElseGet(Book::new);
    }

    public List<Book> getByAuthorId(UUID id) {
        return bookRepository.findByAuthorId(id);
    }


    public List<Book> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book delete(UUID id) {
        Book book = getById(id);
        if(book.getName() != null)
            bookRepository.deleteById(id);
        return book;
    }
}
