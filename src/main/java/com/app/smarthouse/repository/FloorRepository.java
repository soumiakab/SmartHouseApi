package com.app.smarthouse.repository;

import com.app.smarthouse.model.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor,String> {

}
