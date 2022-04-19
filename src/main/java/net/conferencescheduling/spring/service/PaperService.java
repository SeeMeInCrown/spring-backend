package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService{

    private final PaperRepository paperRepository;

    @Autowired
    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getAllPapers(){
        return new ArrayList<>(paperRepository.findAll());
    }

    public Paper getPaper(long paperId){
        return paperRepository.findById(paperId).orElse(null);
    }

    public void updatePaper(long paperId,Paper newPaper){

    }

}
