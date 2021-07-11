package com.example.demo.model;

import lombok.*;


public enum  Role {
    ADMIN("ADMIN"),MASTER("MASTER"),STUDENT("STUDENT");
    Role(String name){
        this.name = name;
    }
    @Getter
    @Setter
    private String name;
}
