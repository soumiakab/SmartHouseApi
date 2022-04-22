package com.app.smarthouse.controller;

import com.app.smarthouse.model.Device;
import com.app.smarthouse.service.impl.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Device>> getAll(){
        return ResponseEntity.ok(deviceService.getAll());
    }

    @PostMapping("/add")
    public Device add(@RequestBody Device device){
        return deviceService.addDevice(device);
    }

    @GetMapping("/getOne/{id}")
    public Device getOne(@PathVariable String id){return deviceService.getOne(id);}

    @PutMapping("/update")
    public Device update(@RequestBody Device device){ return deviceService.updateDevice(device);}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return deviceService.deleteDevice(id);
    }
}
