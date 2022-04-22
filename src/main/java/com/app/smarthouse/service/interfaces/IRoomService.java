package com.app.smarthouse.service.interfaces;

import com.app.smarthouse.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAll();

    Room addRoom(Room room);

    Room getOne(String id);

    Room updateRoom(Room room);

    String deleteRoom(String id);
}
