package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.service.ConstraintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/constraint")
public class ConstraintController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ConstraintService constraintService;

    @PostMapping("/create")
    public ResponseEntity<net.conferencescheduling.spring.model.dto.ConstraintDto> createConstraint(@RequestBody net.conferencescheduling.spring.model.dto.ConstraintDto constraintDto) {

        Constraint constraintRequest = modelMapper.map(constraintDto, Constraint.class);

        Constraint constraint = constraintService.createConstraint(constraintRequest);

        // convert entity to DTO
        net.conferencescheduling.spring.model.dto.ConstraintDto constraintResponse = modelMapper.map(constraint, net.conferencescheduling.spring.model.dto.ConstraintDto.class);

        return new ResponseEntity<>(constraintResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllPapers() {
        try {
            constraintService.deleteAllConstraints();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
