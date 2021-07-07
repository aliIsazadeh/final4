package com.example.demo.model;

import java.util.List;

public class TimeTable {
    public int Id;
    public Master Master ;
    public List<Student>Students;
    public List<TimeTableBell> TimeTableBells;
    public Course Course;

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public Master getMasters() {
        return this.Master;
    }

    public void setMasters(Master MAS) {
        this.Master = MAS;
    }


    public List getStudents() {
        return this.Students;
    }

    public void setStudents(List STU) {
        this.Students = STU;
    }


    public List getTimeTableBell() {
        return this.TimeTableBells;
    }

    public void setTimeTableBells(List TTB) {
        this.TimeTableBells = TTB;
    }


    public Course getCourse() {
        return this.Course;
    }

    public void setCourse(Course CRS) {
        this.Course = CRS;
    }


}
