package com.app.smarthouse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    private String id;
    private Long number;
    @DBRef
    private Floor floor;
    @DBRef
    private Collection<Device> devices;

}
