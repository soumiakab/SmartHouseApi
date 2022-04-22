package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.Device;
import com.app.smarthouse.repository.DeviceRepository;
import com.app.smarthouse.service.interfaces.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService implements IDeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    @Override
    public List<Device> getAll(){
        return deviceRepository.findAll();
    }

    @Override
    public Device addDevice(Device device){
        return deviceRepository.save(device);
    }

    @Override
    public Device getOne(String id){
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public Device updateDevice(Device device){
        Device device1 = deviceRepository.findById(device.getId()).orElse(null);
        if(device1 != null){
            return deviceRepository.save(device);
        }
        return null;
    }

    @Override
    public String deleteDevice(String id) {
        deviceRepository.deleteById(id);
        return "Device removed !!";
    }
}
