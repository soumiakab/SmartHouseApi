package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.repository.FloorRepository;
import com.app.smarthouse.repository.HouseRepository;
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
class FloorServiceTest {

    @InjectMocks
    private FloorService floorService;

    @Mock
    private FloorRepository floorRepository;


    @Test
    void getAll() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Floor floor2 = new Floor("12OZUEIEII", 2L,null,null);
        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        given(floorRepository.findAll()).willReturn(floors);
        List<Floor> floors1 = floorService.getAll();
        assertEquals(floors, floors1);
        //to verify
        verify(floorRepository).findAll();
    }

    @Test
    void addFloor() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.lenient().when(floorRepository.save(floor1)).thenReturn(floor1);
        Floor floor = floorService.addFloor(floor1);
        assertThat(floor).isEqualTo(floor1);

    }

    @Test
    void getOne() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        Floor floor = floorService.getOne(floor1.getId());
        assertThat(floor).isEqualTo(floor1);

    }

    @Test
    void updateFloor() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        Mockito.lenient().when(floorRepository.save(floor1)).thenReturn(floor1);
        Floor floor = floorService.updateFloor(floor1);
        assertThat(floor).isEqualTo(floor1);
    }

    @Test
    void deleteFloor() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        floorService.deleteFloor(floor1.getId());

    }
}