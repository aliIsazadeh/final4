package com.example.demo.model;

import com.example.demo.security.ApplicationUsersPermission;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.model.UserPermission.*;

@NoArgsConstructor
public enum Roles {
    STUDENT(Sets.newHashSet(STUDENT_READ,TIMETABLEBELL_READ,COURSE_READ)),
    MASTER(Sets.newHashSet(STUDENT_READ,MASTER_READ,MASTER_WRITE,TIMETABLEBELL_READ,COURSE_READ)),
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,MASTER_READ,MASTER_WRITE,TIMETABLEBELL_READ,TIMETABLEBELL_WRITE,COURSE_READ,COURSE_WRITE)),
    USER(Sets.newHashSet());

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private  Set<UserPermission> permissions;

    Roles(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
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
