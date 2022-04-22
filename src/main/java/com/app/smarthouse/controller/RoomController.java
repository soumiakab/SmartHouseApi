package com.app.smarthouse.controller;

import com.app.smarthouse.model.Room;
import com.app.smarthouse.service.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Room>> getAll(){
        return ResponseEntity.ok(roomService.getAll());
    }

    @PostMapping("/add")
    public Room add(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @GetMapping("/getOne/{id}")
    public Room getOne(@PathVariable String id){return roomService.getOne(id);}

    @PutMapping("/update")
    public Room update(@RequestBody Room room){ return roomService.updateRoom(room);}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return roomService.deleteRoom(id);
    }
}
