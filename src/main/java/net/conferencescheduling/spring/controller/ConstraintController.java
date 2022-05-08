package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.AuthorDto;
import net.conferencescheduling.spring.model.dto.ConstraintDto;
import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.service.AuthorService;
import net.conferencescheduling.spring.service.ConstraintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class ConstraintController {
    @Autowired
    private ModelMapper modelMapper;

    private final ConstraintService constraintService;

    @Autowired
    public ConstraintController(ConstraintService constraintService) {
        super();
        this.constraintService = constraintService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ConstraintDto>> getAllConstraints() {

        List<ConstraintDto> constraints= constraintService.getAllConstraints().stream().map(constraint -> modelMapper.map(constraint, ConstraintDto.class)).toList();
        return ResponseEntity.ok(constraints);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ConstraintDto> getConstraintById(@PathVariable(name = "id") Long id) {
        Constraint constraint = constraintService.getConstraintById(id);

        // convert entity to DTO
        ConstraintDto constraintResponse = modelMapper.map(constraint, ConstraintDto.class);

        return ResponseEntity.ok().body(constraintResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<ConstraintDto> createConstraint(@RequestBody ConstraintDto constraintDto) {

        // convert DTO to entity
        Constraint constraintRequest = modelMapper.map(constraintDto, Constraint.class);

        Constraint constraint = constraintService.createConstraint(constraintRequest);

        // convert entity to DTO
        ConstraintDto constraintResponse = modelMapper.map(constraint, ConstraintDto.class);

        return new ResponseEntity<ConstraintDto>(constraintResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<ConstraintDto> updateConstraint(@PathVariable Long id, @RequestBody ConstraintDto constraintDto) {

        // convert DTO to Entity
        Constraint constraintRequest = modelMapper.map(constraintDto, Constraint.class);

        Constraint constraint = constraintService.updateConstraint(id, constraintRequest);

        // entity to DTO
        ConstraintDto constraintResponse = modelMapper.map(constraint, ConstraintDto.class);

        return ResponseEntity.ok().body(constraintResponse);
    }

}
