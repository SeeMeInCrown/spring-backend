package net.conferencescheduling.spring.repository;
import net.conferencescheduling.spring.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
