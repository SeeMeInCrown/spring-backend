package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findAuthorByNameAndSurname(String name, String surname);
}
