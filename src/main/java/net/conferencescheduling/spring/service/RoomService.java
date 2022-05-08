package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Room;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import net.conferencescheduling.spring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    private ConstraintRepository constraintRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room roomRequest) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid room!") );

        room.setRoomNo(roomRequest.getRoomNo());
        room.setRoomCount(roomRequest.getRoomCount());
        room.setConstraint(roomRequest.getConstraint());
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        Optional<Room> result = roomRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid room!");
        }

    }

    public Room assignRoomToConstraint(Long roomId, Long constraintId){
        Room room=roomRepository.getById(roomId);
        Constraint constraint=constraintRepository.getById(constraintId);
        room.assignConstraint(constraint);
        return roomRepository.save(room);
    }
}
