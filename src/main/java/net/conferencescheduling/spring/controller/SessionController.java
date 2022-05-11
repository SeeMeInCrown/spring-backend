package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.PaperDto;
import net.conferencescheduling.spring.model.dto.RoomDto;
import net.conferencescheduling.spring.model.dto.SessionDto;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Room;
import net.conferencescheduling.spring.model.entity.Session;
import net.conferencescheduling.spring.service.RoomService;
import net.conferencescheduling.spring.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private ModelMapper modelMapper;

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        super();
        this.sessionService = sessionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SessionDto>> getAllSessions() {

        List<SessionDto> sessions= sessionService.getAllSessions().stream().map(session -> modelMapper.map(session, SessionDto.class)).toList();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SessionDto> getSessionById(@PathVariable(name = "id") Long id) {
        Session session = sessionService.getSessionById(id);

        // convert entity to DTO
        SessionDto sessionResponse = modelMapper.map(session, SessionDto.class);

        return ResponseEntity.ok().body(sessionResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<SessionDto> createSession(@RequestBody SessionDto sessionDto) {

        // convert DTO to entity
        Session sessionRequest = modelMapper.map(sessionDto, Session.class);

        Session session = sessionService.createSession(sessionRequest);

        // convert entity to DTO
        SessionDto sessionResponse = modelMapper.map(session, SessionDto.class);

        return new ResponseEntity<>(sessionResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<SessionDto> updateSession(@PathVariable Long id, @RequestBody SessionDto sessionDto) {

        // convert DTO to Entity
        Session roomRequest = modelMapper.map(sessionDto, Session.class);

        Session session = sessionService.updateSession(id, roomRequest);

        // entity to DTO
        SessionDto sessionResponse = modelMapper.map(session, SessionDto.class);

        return ResponseEntity.ok().body(sessionResponse);
    }

    @PutMapping("/{sessionId}/constraint/{constraintId}")
    public ResponseEntity<SessionDto> assignSessionToConstraint(@PathVariable Long sessionId, @PathVariable Long constraintId) {
        Session session = sessionService.assignSessionToConstraint(sessionId,constraintId);

        SessionDto sessionResponse = modelMapper.map(session, SessionDto.class);

        return ResponseEntity.ok().body(sessionResponse);

    }

}
