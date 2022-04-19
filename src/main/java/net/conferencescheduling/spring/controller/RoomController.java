package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.dto.RoomDto;
import net.conferencescheduling.spring.model.entity.Room;
import net.conferencescheduling.spring.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;


    @PostMapping("/add")
    public void addRoom(@RequestBody Room roomDto){
        roomService.saveRoom(roomDto);
    }


}
