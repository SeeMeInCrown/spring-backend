package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.InfoDto;
import net.conferencescheduling.spring.model.entity.Info;
import net.conferencescheduling.spring.service.InfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    InfoService infoService;

    @PostMapping("/create")
    public ResponseEntity<InfoDto> createConstraint(@RequestBody InfoDto infoDto) {

        Info constraintRequest = modelMapper.map(infoDto, Info.class);

        Info info = infoService.createInfo(constraintRequest);

        // convert entity to DTO
        InfoDto infoResponse = modelMapper.map(info, InfoDto.class);

        return new ResponseEntity<>(infoResponse, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<InfoDto>> getAllPapers() {
        try {
            List<InfoDto> papers = infoService.getAllInfo().stream().map(paper -> modelMapper.map(paper, InfoDto.class)).toList();
            if (papers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(papers);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllInfo() {
        try {
            infoService.deleteAllInfo();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
