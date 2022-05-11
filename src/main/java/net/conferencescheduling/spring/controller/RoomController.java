package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.PaperDto;
import net.conferencescheduling.spring.model.dto.RoomDto;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Room;
import net.conferencescheduling.spring.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private ModelMapper modelMapper;

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        super();
        this.roomService = roomService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RoomDto>> getAllRooms() {

        List<RoomDto> rooms= roomService.getAllRooms().stream().map(room -> modelMapper.map(room, RoomDto.class)).toList();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable(name = "id") Long id) {
        Room room = roomService.getRoomById(id);

        // convert entity to DTO
        RoomDto roomResponse = modelMapper.map(room, RoomDto.class);

        return ResponseEntity.ok().body(roomResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RoomDto> createAuthor(@RequestBody RoomDto roomDto) {

        // convert DTO to entity
        Room roomRequest = modelMapper.map(roomDto, Room.class);

        Room room = roomService.createRoom(roomRequest);

        // convert entity to DTO
        RoomDto roomResponse = modelMapper.map(room, RoomDto.class);

        return new ResponseEntity<RoomDto>(roomResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {

        // convert DTO to Entity
        Room roomRequest = modelMapper.map(roomDto, Room.class);

        Room room = roomService.updateRoom(id, roomRequest);

        // entity to DTO
        RoomDto roomResponse = modelMapper.map(room, RoomDto.class);

        return ResponseEntity.ok().body(roomResponse);
    }

    @PutMapping("/{roomId}/constraint/{constraintId}")
    public ResponseEntity<RoomDto> assignConstraintToRoom(@PathVariable Long roomId, @PathVariable Long constraintId) {
        Room room = roomService.assignRoomToConstraint(roomId,constraintId);

        RoomDto roomResponse = modelMapper.map(room, RoomDto.class);

        return ResponseEntity.ok().body(roomResponse);

    }

}
