package com.example.secretassassin.controller;

import com.example.secretassassin.model.CreateRoom;
import com.example.secretassassin.model.lobby.Players;
import com.example.secretassassin.repository.CreateRoomRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CreateRoomController {

    public final CreateRoomRepository createRoomRepository;

    public CreateRoomController(CreateRoomRepository createRoomRepository) {
        this.createRoomRepository = createRoomRepository;
    }

    @MessageMapping("/creategame-room")
    @SendTo("/rooms/room-lists")
    public CreateRoom createRoom(@RequestBody CreateRoom createRoom) {
        return createRoomRepository.insert(createRoom);
    }


    @GetMapping(value = "/get-all-rooms")
    public List<CreateRoom> getAllRooms() {
        return createRoomRepository.findAll();
    }


    @PostMapping("/join-lobby")
    public Optional<CreateRoom> joinLobby(@RequestBody CreateRoom createRoom) {
        Optional<CreateRoom> newPlayers = createRoomRepository.findById(createRoom.getId());
        List<Players> allPlayers = newPlayers.get().getPlayers();
        allPlayers.add(new Players("aa", "kivanc"));
        createRoomRepository.save(newPlayers.get());
        return newPlayers;
    }
}
