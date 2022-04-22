package com.app.smarthouse.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    private String id;
    @Field(value = "username")
    private String username;
    @Field(value = "password")
    private String password;
    @DBRef
    private House house;

    public User() {
    }


}
