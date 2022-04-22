package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.Room;
import com.app.smarthouse.repository.RoomRepository;
import com.app.smarthouse.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    @Override
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public Room getOne(String id){
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room updateRoom(Room room){
        Room room1 = roomRepository.findById(room.getId()).orElse(null);
        if(room1 != null){
            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public String deleteRoom(String id) {
        roomRepository.deleteById(id);
        return "Room removed !!";
    }
}
