package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.service.ConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/constraint")
public class ConstraintController {

//    @Autowired
//    private ConstraintService constraintService;
//
//    @GetMapping
//    public List<Constraint> getAllConstraints(){
//        return constraintService.getAllConstraints();
//    }
//
////    @GetMapping("/{constId}")
////    public Constraint getConstraintById(@PathVariable Long constId){
////        return constraintService.getConstraintById(constId);
////    }
////
////
////    @GetMapping("/{paperCount}")
////    public Constraint getPaperCount(@PathVariable int paperCount){
////        return constraintService.getPaperCount(paperCount);
////    }
////
////    @GetMapping("/{duration}")
////    public Constraint getDuration(@PathVariable int duration){
////        return constraintService.getDuration(duration);
////    }
////
////    @GetMapping("/{keyword}")
////    public Constraint getDuration(@PathVariable String keyword){
////        return constraintService.getKeyword(keyword);
////    }
//
//    @PostMapping
//    public void saveConstraint(@RequestBody Constraint constraint){
//        constraintService.saveConstraint(constraint);
//    }
//
//


}
