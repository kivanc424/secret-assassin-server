package com.example.secretassassin.controller;

import com.example.secretassassin.model.GameRoom;
import com.example.secretassassin.repository.GameRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRoomController {

    @Autowired
    public GameRoomRepository gameRoomRepository;

    @GetMapping(value = "/getroom")
    public List<GameRoom> getAllGameRoom() {
        return gameRoomRepository.findAll();
    }

    @PostMapping(value = "/createroom")
    public void createGameRoom(@RequestBody GameRoom gameRoom) {
        gameRoomRepository.insert(gameRoom);
    }

}