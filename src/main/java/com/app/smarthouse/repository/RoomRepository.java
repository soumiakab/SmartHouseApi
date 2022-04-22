package com.app.smarthouse.repository;

import com.app.smarthouse.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
}
