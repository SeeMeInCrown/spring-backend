package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.PresentationDto;
import net.conferencescheduling.spring.model.entity.Presentation;
import net.conferencescheduling.spring.service.PresentationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/presentation")
public class PresentationController {
    @Autowired
    private ModelMapper modelMapper;

    private final PresentationService presentationService;

    @Autowired
    public PresentationController(PresentationService presentationService) {
        super();
        this.presentationService = presentationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PresentationDto>> getAllPresentations() {

        List<PresentationDto> presentations= presentationService.getAllPresentations().stream().map(presentation -> modelMapper.map(presentation, PresentationDto.class)).toList();
        return ResponseEntity.ok(presentations);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PresentationDto> getPresentationById(@PathVariable(name = "id") Long id) {
        Presentation presentation = presentationService.getPresentationById(id);

        // convert entity to DTO
        PresentationDto presentationResponse = modelMapper.map(presentation, PresentationDto.class);

        return ResponseEntity.ok().body(presentationResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<PresentationDto> createPresentation(@RequestBody PresentationDto presentationDto) {

        // convert DTO to entity
        Presentation presentationRequest = modelMapper.map(presentationDto, Presentation.class);

        Presentation presentation = presentationService.createPresentation(presentationRequest);

        // convert entity to DTO
        PresentationDto presentationResponse = modelMapper.map(presentation, PresentationDto.class);

        return new ResponseEntity<>(presentationResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<SessionDto> updateSession(@PathVariable Long id, @RequestBody SessionDto sessionDto) {
//
//        // convert DTO to Entity
//        Session roomRequest = modelMapper.map(sessionDto, Session.class);
//
//        Session session = sessionService.updateSession(id, roomRequest);
//
//        // entity to DTO
//        SessionDto sessionResponse = modelMapper.map(session, SessionDto.class);
//
//        return ResponseEntity.ok().body(sessionResponse);
//    }


}
