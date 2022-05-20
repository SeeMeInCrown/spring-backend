//package net.conferencescheduling.spring.controller;
//
//import net.conferencescheduling.spring.model.dto.RoomDto;
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
//public class RoomController {
//    @Autowired
//    private ModelMapper modelMapper;
//
//    private final KeywordService keywordService;
//
//    @Autowired
//    public RoomController(KeywordService keywordService) {
//        super();
//        this.keywordService = keywordService;
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<RoomDto>> getAllRooms() {
//
//        List<RoomDto> rooms= keywordService.getAllRooms().stream().map(keyword -> modelMapper.map(keyword, RoomDto.class)).toList();
//        return ResponseEntity.ok(rooms);
//    }
//
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<RoomDto> getRoomById(@PathVariable(name = "id") Long id) {
//        Keyword keyword = keywordService.getRoomById(id);
//
//        // convert entity to DTO
//        RoomDto roomResponse = modelMapper.map(keyword, RoomDto.class);
//
//        return ResponseEntity.ok().body(roomResponse);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<RoomDto> createAuthor(@RequestBody RoomDto roomDto) {
//
//        // convert DTO to entity
//        Keyword keywordRequest = modelMapper.map(roomDto, Keyword.class);
//
//        Keyword keyword = keywordService.createRoom(keywordRequest);
//
//        // convert entity to DTO
//        RoomDto roomResponse = modelMapper.map(keyword, RoomDto.class);
//
//        return new ResponseEntity<RoomDto>(roomResponse, HttpStatus.CREATED);
//    }
//
//    // change the request for DTO
//    // change the response for DTO
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
//
//        // convert DTO to Entity
//        Keyword keywordRequest = modelMapper.map(roomDto, Keyword.class);
//
//        Keyword keyword = keywordService.updateRoom(id, keywordRequest);
//
//        // entity to DTO
//        RoomDto roomResponse = modelMapper.map(keyword, RoomDto.class);
//
//        return ResponseEntity.ok().body(roomResponse);
//    }
//
//    @PutMapping("/{roomId}/constraint/{constraintId}")
//    public ResponseEntity<RoomDto> assignConstraintToRoom(@PathVariable Long roomId, @PathVariable Long constraintId) {
//        Keyword keyword = keywordService.assignRoomToConstraint(roomId,constraintId);
//
//        RoomDto roomResponse = modelMapper.map(keyword, RoomDto.class);
//
//        return ResponseEntity.ok().body(roomResponse);
//
//    }
//
//}
