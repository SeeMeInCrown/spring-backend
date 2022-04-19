package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstraintService {


    private final ConstraintRepository constraintRepository;

    @Autowired
    public ConstraintService(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }

    public List<Constraint> getAllConstraints() {
        return constraintRepository.findAll();
    }

    public Constraint getConstraintById(Long constId) {
        return constraintRepository.getById(constId);
    }

    public void saveConstraint(Constraint constraint){
        constraintRepository.save(constraint);
    }


}
