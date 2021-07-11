package com.example.demo.model;
public class TimeTableBell implements Cloneable {
    public int Id;
    public Day Day;
    public Bell Bell;
    public TimeTable TimeTable;

    public com.example.demo.model.Day getDay() {
        return Day;
    }

    public void setDay(com.example.demo.model.Day day) {
        Day = day;
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
        return this.Bell;
    }

    public void setBell(Bell BELL) {
        this.Bell = BELL;
    }

    public TimeTable getTimeTable() {
        return this.TimeTable;
    }

    public void setTimeTable(TimeTable TT) {
        this.TimeTable = TT;
    }


}
