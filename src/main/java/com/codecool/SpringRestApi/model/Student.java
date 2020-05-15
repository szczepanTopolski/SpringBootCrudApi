package com.codecool.SpringRestApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Student {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;

    public Student(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
