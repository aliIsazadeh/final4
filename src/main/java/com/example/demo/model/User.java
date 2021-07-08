package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String FirstName;
    private String LastName;
    private String userName;
    private int phoneNum;
    @Enumerated(EnumType.STRING)
    private Roles Role;
}
