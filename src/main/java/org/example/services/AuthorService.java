package org.example.services;

import org.example.entities.Author;
import org.example.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getById(UUID id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.orElseGet(Author::new);
    }


    public List<Author> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public void delete(UUID id) {
        authorRepository.deleteById(id);
    }
}
