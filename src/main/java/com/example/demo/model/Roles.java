package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public enum Roles {
    STUDENT("STUDENT"), MASTER("MASTER"), ADMIN("ADMIN"), USER("USER");
    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Roles of(String role) {
        return Arrays.stream(Roles.values())
                .filter(roles ->
                        roles.getValue().equals(role))
                .findFirst()
                .orElse(USER);
    }

    @Override
    public String toString() {
        return value;
    }
}
