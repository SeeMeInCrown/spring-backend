package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.ConstraintDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstraintRepository extends JpaRepository<ConstraintDto,Long> {

}
