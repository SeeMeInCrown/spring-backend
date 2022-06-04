package net.conferencescheduling.spring.repository;


import net.conferencescheduling.spring.model.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info,Long> {
}
