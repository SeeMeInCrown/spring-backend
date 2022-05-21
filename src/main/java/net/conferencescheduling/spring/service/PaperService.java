package net.conferencescheduling.spring.service;


import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService{

    private final PaperRepository paperRepository;

//    @Autowired
//    private AuthorRepository authorRepository;
//    @Autowired
//    private KeywordRepository keywordRepository;
//    @Autowired
//    private PresenterRepository presenterRepository;

    @Autowired
    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    public Paper createPaper(Paper paper) {
//        List<Keyword> keywords = new ArrayList<>();
//        paper.getKeywords().forEach(keyword -> {
//            Keyword keyword1=keywordRepository.findKeywordByKeyword(keyword.getKeyword());
//            if (keyword1!=null){
//                keywords.add(keyword1);
//            }
//            else {
//                keywords.add(keyword);
//            }
//        });
//        paper.setKeywords(keywords);
//
//        List<Author> authors = new ArrayList<>();
//        paper.getAuthors().forEach(author -> {
//            Author author1=authorRepository.findAuthorByNameAndSurname(author.getName(),author.getSurname());
//            if (author1!=null){
//                authors.add(author1);
//            }
//            else {
//                authors.add(author);
//            }
//        });
//        paper.setAuthors(authors);
//
//        Presenter presenter=paper.getPresenter();
//        Presenter presenter1= presenterRepository.findPresenterByNameAndSurname(presenter.getName(), presenter.getSurname());
//        if (presenter1==null){
//            paper.setPresenter(presenter);
//        }
//        else {
//            paper.setPresenter(presenter1);
//        }
        return paperRepository.save(paper);

    }

    public Paper updatePaper(Long id, Paper paperRequest) {
        Paper paper = paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid paper!") );
        paper.setTitle(paperRequest.getTitle());
        paper.setKeyword(paperRequest.getKeyword());
        paper.setAuthor(paperRequest.getAuthor());
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

    public Paper deleteById(Long paperId) throws Exception {
        if (!paperRepository.existsById(paperId)) {
            throw new Exception("Not found Tutorial with id = " + paperId);
        }
        paperRepository.deleteById(paperId);
        return null;
    }

    public void deleteAllPapers() {
        paperRepository.deleteAll();
    }


//    public Paper assignAuthorToPaper(Long paperId, Long authorId){
//        Paper paper=paperRepository.getById(paperId);
//        Author author=authorRepository.getById(authorId);
//        paper.assignAuthor(author);
//        return paperRepository.save(paper);
//    }
//
//    public Paper assignKeywordToPaper(Long paperId, Long keywordId) {
//        Paper paper=paperRepository.getById(paperId);
//        Keyword keyword=keywordRepository.getById(keywordId);
//        paper.assignKeyword(keyword);
//        return paperRepository.save(paper);
//    }
//
//    public Paper assignPresenterToPaper(Long paperId, Long presenterId) {
//        Paper paper=paperRepository.getById(paperId);
//        Presenter presenter=presenterRepository.getById(presenterId);
//        paper.assignPresenter(presenter);
//        return paperRepository.save(paper);
//    }



}
