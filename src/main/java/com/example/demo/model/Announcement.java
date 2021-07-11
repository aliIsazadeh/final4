package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int timeTableId;
    private String message;

    public Announcement(int timeTableId, String message) {
        this.timeTableId = timeTableId;
        this.message = message;
    }
}
