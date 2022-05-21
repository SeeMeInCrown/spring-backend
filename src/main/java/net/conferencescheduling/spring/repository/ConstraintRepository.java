package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Constraint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstraintRepository extends JpaRepository<Constraint,Long> {

}
