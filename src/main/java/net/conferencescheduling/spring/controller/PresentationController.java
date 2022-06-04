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

        List<PresentationDto> presentations= presentationService.getAllPresentations().
                stream().map(presentation -> modelMapper.map(presentation, PresentationDto.class)).toList();
        //List<PresentationDto> presentations= presentationService.getAllPresentations();
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
    public ResponseEntity<List<PresentationDto>> createPresentation() {

        List<PresentationDto> presentations= presentationService.createPresentation().
                stream().map(presentation -> modelMapper.map(presentation, PresentationDto.class)).toList();
        //List<PresentationDto> presentations= presentationService.getAllPresentations();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllPresentations() {
        try {
            presentationService.deleteAllPresentations();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
