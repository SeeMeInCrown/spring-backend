package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.PaperDto;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.service.PaperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private ModelMapper modelMapper;

    private final PaperService paperService;

    @Autowired
    public PaperController(PaperService paperService) {
        super();
        this.paperService = paperService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PaperDto>> getAllPapers() {
        try {
            List<PaperDto> papers = paperService.getAllPapers().stream().map(paper -> modelMapper.map(paper, PaperDto.class)).toList();
            if (papers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(papers);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PaperDto> getPaperById(@PathVariable(name = "id") Long id) {
        Paper paper = paperService.getPaperById(id);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<PaperDto> createPaper(@RequestBody PaperDto paperDto) {

        Paper paperRequest = modelMapper.map(paperDto, Paper.class);

        Paper paper = paperService.createPaper(paperRequest);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return new ResponseEntity<>(paperResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<PaperDto> deletePaper(@PathVariable(name = "id") Long id) throws Exception {


        Paper paper= paperService.deleteById(id);
        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);
        return ResponseEntity.ok().body(paperResponse);
    }

    @DeleteMapping("/deleteByTitle/{title}")
    public ResponseEntity<PaperDto> deletePaperByTitle(@PathVariable(name = "title") String title) throws Exception {
        Paper paper= paperService.deleteByTitle(title);
        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);
        return ResponseEntity.ok().body(paperResponse);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PaperDto> updatePaper(@PathVariable Long id, @RequestBody PaperDto paperDto) {

        Paper paperRequest = modelMapper.map(paperDto, Paper.class);

        Paper paper = paperService.updatePaper(id, paperRequest);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllPapers() {
        try {
            paperService.deleteAllPapers();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/{paperId}/authors/{authorId}")
//    public ResponseEntity<PaperDto> assignAuthorToPaper(@PathVariable Long paperId, @PathVariable Long authorId) {
//        Paper paper = paperService.assignAuthorToPaper(paperId,authorId);
//
//        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);
//
//        return ResponseEntity.ok().body(paperResponse);
//
//    }
//
//    @PutMapping("/{paperId}/keyword/{keywordId}")
//    public ResponseEntity<PaperDto> assignKeywordToPaper(@PathVariable Long paperId, @PathVariable Long keywordId) {
//        Paper paper = paperService.assignKeywordToPaper(paperId,keywordId);
//
//        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);
//
//        return ResponseEntity.ok().body(paperResponse);
//
//    }
//
//    @PutMapping("/{paperId}/presenter/{presenterId}")
//    public ResponseEntity<PaperDto> assignPresenterToPaper(@PathVariable Long paperId, @PathVariable Long presenterId) {
//        Paper paper = paperService.assignPresenterToPaper(paperId,presenterId);
//
//        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);
//
//        return ResponseEntity.ok().body(paperResponse);
//
//    }


}
