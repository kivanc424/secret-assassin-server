package com.example.secretassassin.controller;

import com.example.secretassassin.model.CreateRoom;
import com.example.secretassassin.repository.CreateRoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateRoomController {

    public final CreateRoomRepository createRoomRepository;

    public CreateRoomController(CreateRoomRepository createRoomRepository) {
        this.createRoomRepository = createRoomRepository;
    }

    @PostMapping(value = "/create-room")
    @CrossOrigin
    public CreateRoom createRoom(@RequestBody CreateRoom createRoom) {
        return createRoomRepository.insert(createRoom);
    }


    @GetMapping(value = "/get-all-rooms")
    @CrossOrigin
    public List<CreateRoom> getAllRooms() {
        return createRoomRepository.findAll();
    }
}
