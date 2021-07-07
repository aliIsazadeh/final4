package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    public int Id;
    public String FirstName;
    public String LastName;
    public String email;
    public String code;
    public int phoneNum;
    public String Role;
}
