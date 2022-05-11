package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.AuthorDto;
import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private ModelMapper modelMapper;

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {

        List<AuthorDto> authors= authorService.getAllAuthors().stream().map(author -> modelMapper.map(author, AuthorDto.class)).toList();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") Long id) {
        Author author = authorService.getAuthorById(id);

        // convert entity to DTO
        AuthorDto authorResponse = modelMapper.map(author, AuthorDto.class);

        return ResponseEntity.ok().body(authorResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {

        // convert DTO to entity
        Author authorRequest = modelMapper.map(authorDto, Author.class);

        Author author = authorService.createAuthor(authorRequest);

        // convert entity to DTO
        AuthorDto authorResponse = modelMapper.map(author, AuthorDto.class);

        return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/edit/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {

        // convert DTO to Entity
        Author authorRequest = modelMapper.map(authorDto, Author.class);

        Author author = authorService.updateAuthor(id, authorRequest);

        // entity to DTO
        AuthorDto authorResponse = modelMapper.map(author, AuthorDto.class);

        return ResponseEntity.ok().body(authorResponse);
    }

}
