package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorRequest) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid author!") );

        author.setName(authorRequest.getName());
        author.setSurname(authorRequest.getSurname());
        return authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        Optional<Author> result = authorRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid paper!");
        }

    }

}
