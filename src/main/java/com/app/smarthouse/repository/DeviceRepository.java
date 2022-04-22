package com.app.smarthouse.repository;

import com.app.smarthouse.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device,String> {
}
