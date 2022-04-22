package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.repository.FloorRepository;
import com.app.smarthouse.service.interfaces.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService implements IFloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Override
    public List<Floor> getAll(){
        return floorRepository.findAll();
    }

    @Override
    public Floor addFloor(Floor floor){
        return floorRepository.save(floor);
    }

    @Override
    public Floor getOne(String id){ return floorRepository.findById(id).orElse(null);}

    @Override
    public Floor updateFloor(Floor floor){
        Floor floor1 = floorRepository.findById(floor.getId()).orElse(null);
        if(floor1 != null){
            return floorRepository.save(floor);
        }
        return null;
    }

    @Override
    public String deleteFloor(String id) {
        floorRepository.deleteById(id);
        return "Floor removed !!";
    }
}
