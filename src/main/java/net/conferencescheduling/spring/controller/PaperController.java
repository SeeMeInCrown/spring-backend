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
@CrossOrigin(origins = "http://localhost:8080")
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

        List<PaperDto> papers= paperService.getAllPapers().stream().map(paper -> modelMapper.map(paper, PaperDto.class)).toList();
        return ResponseEntity.ok(papers);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PaperDto> getPaperById(@PathVariable(name = "id") Long id) {
        Paper paper = paperService.getPaperById(id);

        // convert entity to DTO
        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);
    }


    @PostMapping("/create")
    public ResponseEntity<PaperDto> createPaper(@RequestBody PaperDto paperDto) {


        // convert DTO to entity
        Paper paperRequest = modelMapper.map(paperDto, Paper.class);

        Paper paper = paperService.createPaper(paperRequest);

        // convert entity to DTO
        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return new ResponseEntity<>(paperResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<PaperDto> updatePaper(@PathVariable Long id, @RequestBody PaperDto paperDto) {

        // convert DTO to Entity
        Paper paperRequest = modelMapper.map(paperDto, Paper.class);

        Paper paper = paperService.updatePaper(id, paperRequest);

        // entity to DTO
        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);
    }

    @PutMapping("/{paperId}/authors/{authorId}")
    public ResponseEntity<PaperDto> assignAuthorToPaper(@PathVariable Long paperId, @PathVariable Long authorId) {
        Paper paper = paperService.assignAuthorToPaper(paperId,authorId);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);

    }

    @PutMapping("/{paperId}/constraint/{constId}")
    public ResponseEntity<PaperDto> assignConstraintToPaper(@PathVariable Long paperId, @PathVariable Long constId) {
        Paper paper = paperService.assignConstraintToPaper(paperId,constId);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);

    }

    @PutMapping("/{paperId}/presenter/{presenterId}")
    public ResponseEntity<PaperDto> assignPresenterToPaper(@PathVariable Long paperId, @PathVariable Long presenterId) {
        Paper paper = paperService.assignPresenterToPaper(paperId,presenterId);

        PaperDto paperResponse = modelMapper.map(paper, PaperDto.class);

        return ResponseEntity.ok().body(paperResponse);

    }


}
