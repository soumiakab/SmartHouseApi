package com.app.smarthouse.service.interfaces;

import com.app.smarthouse.model.House;

import java.util.List;

public interface IHouseService {
    List<House> getAll();

    House addHouse(House house);

    House getOne(String id);

    House updateHouse(House house);

    String deleteHouse(String id);
}
