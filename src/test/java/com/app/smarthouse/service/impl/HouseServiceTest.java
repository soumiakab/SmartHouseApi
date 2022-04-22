package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.House;
import com.app.smarthouse.repository.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
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
class HouseServiceTest {

    @InjectMocks
    private HouseService houseService;

    @Mock
    private HouseRepository houseRepository;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp(){
        houseService = new HouseService(houseRepository,userService);
    }

    @Test
    void getAll() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        House house2 = new House("12OZ456II","HOUSE2","safi",null,null);
        List<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        given(houseRepository.findAll()).willReturn(houses);
        List<House> houseList = houseService.getAll();
        assertEquals(houses, houseList);
        //to verify
        verify(houseRepository).findAll();
    }

    @Test
    void addHouse() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.lenient().when(houseRepository.save(house1)).thenReturn(house1);
        //House house = houseService.addHouse(house1);
        //assertThat(house).isEqualTo(house1);

    }

    @Test
    void getOne() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.lenient().when(houseRepository.findById(house1.getId())).thenReturn(Optional.of(house1));
        House house = houseService.getOne(house1.getId());
        assertThat(house).isEqualTo(house1);

    }

    @Test
    void updateHouse() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.lenient().when(houseRepository.findById(house1.getId())).thenReturn(Optional.of(house1));
        Mockito.lenient().when(houseRepository.save(house1)).thenReturn(house1);
        House house = houseService.updateHouse(house1);
        assertThat(house).isEqualTo(house1);

    }

    @Test
    void deleteHouse() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.lenient().when(houseRepository.findById(house1.getId())).thenReturn(Optional.of(house1));
        houseService.deleteHouse(house1.getId());

    }
}