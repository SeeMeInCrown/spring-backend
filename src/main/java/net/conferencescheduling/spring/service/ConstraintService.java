package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstraintService{

    private final ConstraintRepository constraintRepository;

    @Autowired
    public ConstraintService(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }

    public List<Constraint> getAllConstraints() {
        return constraintRepository.findAll();
    }

    public Constraint createConstraint(Constraint constraint) {
        return constraintRepository.save(constraint);
    }

    public Constraint updateConstraint(Long id, Constraint constraintRequest) {
        Constraint constraint = constraintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid constraint!") );

        constraint.setBreakCount(constraintRequest.getBreakCount());
        constraint.setBreakTime(constraintRequest.getBreakTime());
        constraint.setPaperCount(constraintRequest.getPaperCount());
        constraint.setStartDate(constraintRequest.getStartDate());
        constraint.setEndDate(constraintRequest.getEndDate());
        constraint.setPapers(constraintRequest.getPapers());
        return constraintRepository.save(constraint);
    }

    public Constraint getConstraintById(Long id) {
        Optional<Constraint> result = constraintRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid constraint!");
        }

    }

}
