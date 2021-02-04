package com.example.secretassassin.controller;

import com.example.secretassassin.model.CreateRoom;
import com.example.secretassassin.model.lobby.Player;
import com.example.secretassassin.repository.CreateRoomRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CreateRoomController {

    public final CreateRoomRepository createRoomRepository;

    public CreateRoomController(CreateRoomRepository createRoomRepository) {
        this.createRoomRepository = createRoomRepository;
    }


    @PostMapping("/create-game")
    public CreateRoom createRoom(@RequestBody CreateRoom createRoom) {
        return createRoomRepository.insert(createRoom);
    }

    @PostMapping("/get-lobby")
    public Optional<CreateRoom> getLobby(@RequestBody CreateRoom createRoom) {
        return createRoomRepository.findById(createRoom.getId());
    }



    @MessageMapping("/lobby")
    @SendTo("/rooms/join-lobby")
    public Player joinLobby(@RequestBody Player player) {
         Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
         List<Player> playerList = room.get().getPlayers();
         playerList.add(new Player(player.getId(), player.getLobbyId(), player.getUsername()));

         createRoomRepository.save(room.get());

        return player;
    }


    @MessageMapping("/leave-lobby")
    @SendTo("/rooms/leave-lobby")
    public Player leaveLobby(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        List<Player> playerList = room.get().getPlayers();
        playerList.removeIf(playerIterator -> playerIterator.getId().equals(player.getId()));

        createRoomRepository.save(room.get());

        return player;
    }



    @GetMapping(value = "/get-all-rooms")
    public List<CreateRoom> getAllRooms() {
        return createRoomRepository.findAll();
    }


}
