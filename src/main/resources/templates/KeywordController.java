//package net.conferencescheduling.spring.controller;
//
//import net.conferencescheduling.spring.model.dto.KeywordDto;
//import net.conferencescheduling.spring.model.entity.Keyword;
//import net.conferencescheduling.spring.service.KeywordService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:8080")
//@RequestMapping("/keyword")
//public class KeywordController {
//    @Autowired
//    private ModelMapper modelMapper;
//
//    private final KeywordService keywordService;
//
//    @Autowired
//    public KeywordController(KeywordService keywordService) {
//        super();
//        this.keywordService = keywordService;
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<KeywordDto>> getAllKeywords() {
//
//        List<KeywordDto> keywords= keywordService.getAllKeywords().stream().map(keyword -> modelMapper.map(keyword, KeywordDto.class)).toList();
//        return ResponseEntity.ok(keywords);
//    }
//
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<KeywordDto> getKeywordById(@PathVariable(name = "id") Long id) {
//        Keyword keyword = keywordService.getKeywordById(id);
//
//        // convert entity to DTO
//        KeywordDto keywordResponse = modelMapper.map(keyword, KeywordDto.class);
//
//        return ResponseEntity.ok().body(keywordResponse);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<KeywordDto> createAuthor(@RequestBody KeywordDto keywordDto) {
//
//        // convert DTO to entity
//        Keyword keywordRequest = modelMapper.map(keywordDto, Keyword.class);
//
//        Keyword keyword = keywordService.createKeyword(keywordRequest);
//
//        // convert entity to DTO
//        KeywordDto keywordResponse = modelMapper.map(keyword, KeywordDto.class);
//
//        return new ResponseEntity<>(keywordResponse, HttpStatus.CREATED);
//    }
//
//    // change the request for DTO
//    // change the response for DTO
////    @PutMapping("/edit/{id}")
////    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
////
////        // convert DTO to Entity
////        Keyword keywordRequest = modelMapper.map(roomDto, Keyword.class);
////
////        Keyword keyword = keywordService.updateRoom(id, keywordRequest);
////
////        // entity to DTO
////        RoomDto roomResponse = modelMapper.map(keyword, RoomDto.class);
////
////        return ResponseEntity.ok().body(roomResponse);
////    }
//
//
//}
