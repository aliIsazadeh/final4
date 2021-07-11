package com.example.demo.model;
public class TimeTableBell implements Cloneable {
    public int Id;
    public Day day;
    public Bell bell;
    public TimeTable timeTable;

    public com.example.demo.model.Day getDay() {
        return day;
    }

    public void setDay(com.example.demo.model.Day day) {
        day = day;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected;

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public Bell getBell() {
        return this.bell;
    }

    public void setBell(Bell BELL) {
        this.bell = BELL;
    }

    public TimeTable getTimeTable() {
        return this.timeTable;
    }

    public void setTimeTable(TimeTable TT) {
        this.timeTable = TT;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TimeTableBell timeTable = new TimeTableBell();
        timeTable.setBell(this.bell);
        timeTable.setDay(this.day);
        return timeTable;
    }

    public TimeTableBell(Day day, Bell bell) {
        this.day = day;
        this.bell = bell;
    }

    public TimeTableBell() {

    }


}
