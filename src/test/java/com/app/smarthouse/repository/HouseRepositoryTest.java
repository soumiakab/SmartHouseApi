package com.app.smarthouse.repository;

import com.app.smarthouse.model.House;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class HouseRepositoryTest {

    @Mock
    private HouseRepository houseRepository;

    @Test
    void getAll() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        House house2 = new House("12OZ456II","HOUSE2","safi",null,null);
        List<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        Mockito.when(houseRepository.findAll()).thenReturn(houses);
        assertThat(houseRepository.findAll()).isNotNull();
    }

    @Test
    void add() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.when(houseRepository.save(house1))
                .thenReturn(house1);
        assertThat(houseRepository.save(house1)).isEqualTo(house1);
    }

    @Test
    @Disabled
    void delete() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        houseRepository.deleteById(house1.getId());
        assertThat(houseRepository.findById(house1.getId())).isNotNull();
    }

    @Test
    void findById() {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        Mockito.when(houseRepository.findById(house1.getId())).thenReturn(Optional.of(house1));
        assertThat(houseRepository.findById(house1.getId())).isNotNull();
    }
}