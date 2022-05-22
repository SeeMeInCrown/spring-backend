package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    void deleteByTitle(String title);
    boolean existsByTitle(String title);
}
