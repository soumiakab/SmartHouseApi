package com.app.smarthouse.model;

import com.app.smarthouse.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Device {

    @Id
    private String id;
    private Status status;
    private String name;
    @DBRef
    private Room room;


}
