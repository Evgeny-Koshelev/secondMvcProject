package org.example.repositories;

import org.example.entities.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends PagingAndSortingRepository <Book, UUID>{

    Optional<Book> findById(UUID id);

    Book save(Book book);

    List<Book> findByAuthorId(UUID authorId);

    void deleteById(UUID id);
}
