package com.example.secretassassin.repository;

import com.example.secretassassin.model.GameRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomRepository extends MongoRepository<GameRoom, String> {
}