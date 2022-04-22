package com.app.smarthouse.service.interfaces;

import com.app.smarthouse.model.Floor;

import java.util.List;

public interface IFloorService {
    List<Floor> getAll();

    Floor addFloor(Floor floor);

    Floor getOne(String id);

    Floor updateFloor(Floor floor);

    String deleteFloor(String id);
}
