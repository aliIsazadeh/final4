package com.example.demo.model;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write"),
    MASTER_READ("master:read"),
    MASTER_WRITE("master:write"),
    TIMETABLEBELL_READ("timetableread:read"),
    TIMETABLEBELL_WRITE("timetableread:write");


    private final String permission;
    UserPermission(String permission) {
        this.permission = permission;
    }



    public String getPermission(){
        return permission;
    }
}
