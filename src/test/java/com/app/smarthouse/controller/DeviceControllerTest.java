package com.app.smarthouse.controller;

import com.app.smarthouse.enums.Status;
import com.app.smarthouse.model.Device;
import com.app.smarthouse.model.Floor;
import com.app.smarthouse.service.impl.DeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeviceController.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceService deviceService;


    @Test
    void getAll() throws Exception {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        Device device2 = new Device("12OZUEIEII", Status.OFF,"TV",null);
        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        when(deviceService.getAll()).thenReturn(devices);
        mockMvc.perform(get("/api/device/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void add() throws Exception {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        when(deviceService.addDevice(device1))
                .thenReturn(device1);
        mockMvc.perform(post("/api/device/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(device1)))
                .andExpect(status().isOk());
    }

    @Test
    void getOne() throws Exception {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        when(deviceService.getOne(device1.getId())).thenReturn(device1);
        mockMvc.perform(get("/api/device/getOne/" + device1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        when(deviceService.updateDevice(device1))
                .thenReturn(device1);
        mockMvc.perform(put("/api/device/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(device1)))
                .andExpect(status().isOk());

    }


}