package com.example.demo.model.requestBodyModels;


import lombok.Data;

@Data
public class EditProfileUser {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
