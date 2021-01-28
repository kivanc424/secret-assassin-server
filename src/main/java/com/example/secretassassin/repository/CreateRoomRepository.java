package com.example.secretassassin.repository;

import com.example.secretassassin.model.CreateRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateRoomRepository extends MongoRepository<CreateRoom, String> {
}
