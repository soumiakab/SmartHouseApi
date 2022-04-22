package com.app.smarthouse.controller;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.service.impl.FloorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FloorController.class)
class FloorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FloorService floorService;

    @Test
    void getAll() throws Exception {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Floor floor2 = new Floor("12OZUEIEII", 2L,null,null);
        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        when(floorService.getAll()).thenReturn(floors);
        mockMvc.perform(get("/api/floor/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void add() throws Exception {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        when(floorService.addFloor(floor1))
                .thenReturn(floor1);
        mockMvc.perform(post("/api/floor/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(floor1)))
                .andExpect(status().isOk());
    }

    @Test
    void getOne() throws Exception {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        when(floorService.getOne(floor1.getId())).thenReturn(floor1);
        mockMvc.perform(get("/api/floor/getOne/" + floor1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void update() throws Exception {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        when(floorService.updateFloor(floor1))
                .thenReturn(floor1);
        mockMvc.perform(put("/api/floor/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(floor1)))
                .andExpect(status().isOk());

    }


}