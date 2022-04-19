package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
