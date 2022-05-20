package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.dto.KeywordDto;
import net.conferencescheduling.spring.model.dto.PresentationDto;
import net.conferencescheduling.spring.model.entity.ConstraintDto;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import org.hibernate.mapping.Constraint;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstraintService{

    private final ConstraintRepository constraintRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ConstraintService(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }

    public ConstraintDto createConstraint(ConstraintDto constraint) {
        return constraintRepository.save(constraint);
    }

    public List<ConstraintDto> getAllConstraints() {

        return constraintRepository.findAll().stream().map(constraint -> modelMapper.map(constraint, ConstraintDto.class)).toList();
    }
}
