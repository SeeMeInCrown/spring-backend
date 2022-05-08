package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Presenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresenterRepository extends JpaRepository<Presenter, Long> {
    //Presenter getPresenterById(Long id);
   // Presenter findPresenterByName(String name);
}
