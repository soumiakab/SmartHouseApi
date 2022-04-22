package com.app.smarthouse.controller;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.model.Room;
import com.app.smarthouse.service.impl.RoomService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Test
    void getAll() throws Exception {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Room room2 = new Room("ZERT456",7L,null,null);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        when(roomService.getAll()).thenReturn(rooms);
        mockMvc.perform(get("/api/room/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void add() throws Exception {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        when(roomService.addRoom(room1))
                .thenReturn(room1);
        mockMvc.perform(post("/api/room/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(room1)))
                .andExpect(status().isOk());
    }

    @Test
    void getOne() throws Exception {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        when(roomService.getOne(room1.getId())).thenReturn(room1);
        mockMvc.perform(get("/api/room/getOne/" + room1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        when(roomService.updateRoom(room1))
                .thenReturn(room1);
        mockMvc.perform(put("/api/room/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(room1)))
                .andExpect(status().isOk());
    }


}