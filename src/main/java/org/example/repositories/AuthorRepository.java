package org.example.repositories;

import org.example.entities.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository <Author, UUID>{

    Optional<Author> findById(UUID id);

    Author save(Author author);

    void deleteById(UUID id);
}
