package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Presenter;
import net.conferencescheduling.spring.repository.AuthorRepository;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import net.conferencescheduling.spring.repository.PaperRepository;
import net.conferencescheduling.spring.repository.PresenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService{

    private final PaperRepository paperRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ConstraintRepository constraintRepository;
    @Autowired
    private PresenterRepository presenterRepository;

    @Autowired
    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    public Paper createPaper(Paper paper) {
        return paperRepository.save(paper);
    }

    public Paper updatePaper(Long id, Paper paperRequest) {
        Paper paper = paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid paper!") );

        paper.setTitle(paperRequest.getTitle());
        paper.setKeyword(paperRequest.getKeyword());
        paper.setAuthors(paperRequest.getAuthors());
        paper.setConstraint(paperRequest.getConstraint());
        paper.setPresenter(paperRequest.getPresenter());
        return paperRepository.save(paper);
    }


    public Paper getPaperById(Long id) {
        Optional<Paper> result = paperRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid paper!");
        }

    }
    public Paper assignAuthorToPaper(Long paperId, Long authorId){
        Paper paper=paperRepository.getById(paperId);
        Author author=authorRepository.getById(authorId);
        paper.assignAuthor(author);
        return paperRepository.save(paper);
    }

    public Paper assignConstraintToPaper(Long paperId, Long constId) {
        Paper paper=paperRepository.getById(paperId);
        Constraint constraint=constraintRepository.getById(constId);
        paper.assignConstraint(constraint);
        return paperRepository.save(paper);
    }

    public Paper assignPresenterToPaper(Long paperId, Long presenterId) {
        Paper paper=paperRepository.getById(paperId);
        Presenter presenter=presenterRepository.getById(presenterId);
        paper.assignPresenter(presenter);
        return paperRepository.save(paper);
    }






    //    public void deletePaper(Long id) {
//        Paper paper = paperRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No valid paper!") );
//
//        paperRepository.delete(paper);
//    }

}
