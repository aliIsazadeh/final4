package com.example.demo.model.requestBodyModels;

import com.example.demo.model.Role;
import lombok.Data;

@Data
public class AddUser {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private Role role;
}
