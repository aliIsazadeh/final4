package com.example.demo.model;

import java.util.List;

public class Master {
    public int Id;
    public List<TimeTable> TimeTable;
    public List<TimeTableBell> TimeTableBells;
    public List<Course>Courses;


    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public List getTimeTableBell() {
        return this.TimeTableBells;
    }

    public void setTimeTableBells(List TTB) {
        this.TimeTableBells = TTB;
    }

    public List getTimeTable() {
        return this.TimeTable;
    }

    public void setTimeTable(List TT) {
        this.TimeTable = TT;
    }

    public List<Course> getCourse() {
        return this.Courses;
    }

    public void setCourse(List CRS) {
        this.Courses = CRS;
    }


}
