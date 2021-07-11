package com.example.demo.model;

import java.util.List;

public class TimeTable {
    public int Id;
    public Master master ;
    public List<Student> students;
    public TimeTableBell timeTableBells;
    public Course course;

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public Master getMasters() {
        return this.master;
    }

    public void setMasters(Master MAS) {
        this.master = MAS;
    }


    public List getStudents() {
        return this.students;
    }

    public void setStudents(List STU) {
        this.students = STU;
    }


    public TimeTableBell getTimeTableBell() {
        return this.timeTableBells;
    }

    public void setTimeTableBells(TimeTableBell TTB) {
        this.timeTableBells = TTB;
    }


    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course CRS) {
        this.course = CRS;
    }

    @Override
    public String toString() {
        return "TimeTable {\n" +
                "master : " + master.getName() +
                "\ncourse=" + course.getTitle() +
                "\ntimeTableBell {\n" + "\t\tday : "+timeTableBells.getDay().getDayOfWeek()
                +"\n\t\tbell : :"+timeTableBells.getBell().bellOfDay+"\n}\n"+
                "}\n";
    }


}
