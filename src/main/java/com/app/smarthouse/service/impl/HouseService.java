package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.House;
import com.app.smarthouse.model.User;
import com.app.smarthouse.repository.HouseRepository;
import com.app.smarthouse.service.interfaces.IHouseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseService implements IHouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserService userService;



    @Override
    public List<House> getAll(){
        return houseRepository.findAll();
    }

    @Override
    public House addHouse(House house){
        User getUserData = userService.getOne(house.getUser().getId());
        if(getUserData != null){
            house.setUser(getUserData);
            houseRepository.save(house);
        }
        return house;
    }

    @Override
    public House getOne(String id){
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public House updateHouse(House house){
        House house1 = houseRepository.findById(house.getId()).orElse(null);
        if(house1 != null){
           return houseRepository.save(house);
        }
        return null;
    }

    @Override
    public String deleteHouse(String id) {
        houseRepository.deleteById(id);
        return "House removed !!";
    }
}
