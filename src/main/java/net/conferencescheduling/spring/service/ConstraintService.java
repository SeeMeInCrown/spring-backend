package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.dto.ConstraintDto;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.repository.ConstraintRepository;
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

    public Constraint createConstraint(Constraint constraint) {
        return constraintRepository.save(constraint);
    }

    public List<ConstraintDto> getAllConstraints() {

        return constraintRepository.findAll().stream().map(constraint -> modelMapper.map(constraint, ConstraintDto.class)).toList();
    }
}
