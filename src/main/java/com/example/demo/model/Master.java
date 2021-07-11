package com.example.demo.model;

import java.util.List;

public class Master {
    public int Id;
    public List<TimeTable> TimeTable;
    public List<TimeTableBell> TimeTableBells;
    public List<Course>Courses;
    public String name ;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<com.example.demo.model.TimeTable> getTimeTable() {
        return TimeTable;
    }

    public void setTimeTable(List<com.example.demo.model.TimeTable> timeTable) {
        TimeTable = timeTable;
    }

    public List<TimeTableBell> getTimeTableBells() {
        return TimeTableBells;
    }

    public void setTimeTableBells(List<TimeTableBell> timeTableBells) {
        TimeTableBells = timeTableBells;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> courses) {
        Courses = courses;
    }

    public Master(String name) {
        this.name = name;
    }

    public Master() {

    }

    public String getName() {


        return name;
    }
}
