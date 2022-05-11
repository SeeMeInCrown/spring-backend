package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.PresenterDto;
import net.conferencescheduling.spring.model.entity.Presenter;
import net.conferencescheduling.spring.service.PresenterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/presenter")
public class PresenterController {
    @Autowired
    private ModelMapper modelMapper;

    private final PresenterService presenterService;

    @Autowired
    public PresenterController(PresenterService presenterService) {
        super();
        this.presenterService = presenterService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PresenterDto>> getAllPresenters() {

        List<PresenterDto> presenters= presenterService.getAllPresenters().stream().map(presenter -> modelMapper.map(presenter, PresenterDto.class)).toList();
        return ResponseEntity.ok(presenters);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PresenterDto> getAuthorById(@PathVariable(name = "id") Long id) {
        Presenter presenter = presenterService.getPresenterById(id);

        // convert entity to DTO
        PresenterDto presenterResponse = modelMapper.map(presenter, PresenterDto.class);

        return ResponseEntity.ok().body(presenterResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<PresenterDto> createPresenter(@RequestBody PresenterDto presenterDto) {

        // convert DTO to entity
        Presenter presenterRequest = modelMapper.map(presenterDto, Presenter.class);

        Presenter presenter = presenterService.createPresenter(presenterRequest);

        // convert entity to DTO
        PresenterDto presenterResponse = modelMapper.map(presenter, PresenterDto.class);

        return new ResponseEntity<>(presenterResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<PresenterDto> updatePresenter(@PathVariable Long id, @RequestBody PresenterDto presenterDto) {

        // convert DTO to Entity
        Presenter presenterRequest = modelMapper.map(presenterDto, Presenter.class);

        Presenter presenter = presenterService.updatePresenter(id, presenterRequest);

        // entity to DTO
        PresenterDto presenterResponse = modelMapper.map(presenter, PresenterDto.class);

        return ResponseEntity.ok().body(presenterResponse);
    }

}
