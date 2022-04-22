package com.app.smarthouse.service.interfaces;

import com.app.smarthouse.model.Device;

import java.util.List;

public interface IDeviceService {
    List<Device> getAll();

    Device addDevice(Device device);

    Device getOne(String id);

    Device updateDevice(Device device);

    String deleteDevice(String id);
}
