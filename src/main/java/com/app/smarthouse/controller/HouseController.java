package com.app.smarthouse.controller;

import com.app.smarthouse.model.House;
import com.app.smarthouse.service.impl.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<House>> getAll(){
        return ResponseEntity.ok(houseService.getAll());
    }

    @PostMapping("/add")
    public House addHouse(@RequestBody House house){
        return houseService.addHouse(house);
    }

    @GetMapping("/getOne/{id}")
    public House getOne(@PathVariable String id){
        return houseService.getOne(id);
    }

    @PutMapping("/update")
    public House updateHouse(@RequestBody House house){
        return houseService.updateHouse(house);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHouse(@PathVariable String id){return houseService.deleteHouse(id);}
}
