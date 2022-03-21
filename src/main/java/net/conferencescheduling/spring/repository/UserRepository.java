package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
