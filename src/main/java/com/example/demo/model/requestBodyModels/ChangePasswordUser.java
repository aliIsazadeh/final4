package com.example.demo.model.requestBodyModels;

import lombok.Data;

@Data
public class ChangePasswordUser {
    private String currentPassword;
    private String newPassword;
}
