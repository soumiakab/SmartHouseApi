package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.model.Room;
import com.app.smarthouse.repository.FloorRepository;
import com.app.smarthouse.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;


    @Test
    void getAll() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Room room2 = new Room("ZERT456",7L,null,null);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        given(roomRepository.findAll()).willReturn(rooms);
        List<Room> roomList = roomService.getAll();
        assertEquals(rooms, roomList);
        //to verify
        verify(roomRepository).findAll();

    }

    @Test
    void addRoom() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Mockito.lenient().when(roomRepository.save(room1)).thenReturn(room1);
        Room room = roomService.addRoom(room1);
        assertThat(room).isEqualTo(room1);
    }

    @Test
    void getOne() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Mockito.lenient().when(roomRepository.findById(room1.getId())).thenReturn(Optional.of(room1));
        Room room = roomService.getOne(room1.getId());
        assertThat(room).isEqualTo(room1);

    }

    @Test
    void updateRoom() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Mockito.lenient().when(roomRepository.findById(room1.getId())).thenReturn(Optional.of(room1));
        Mockito.lenient().when(roomRepository.save(room1)).thenReturn(room1);
        Room room = roomService.updateRoom(room1);
        assertThat(room).isEqualTo(room1);

    }

    @Test
    void deleteRoom() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Mockito.lenient().when(roomRepository.findById(room1.getId())).thenReturn(Optional.of(room1));
        roomService.deleteRoom(room1.getId());

    }
}