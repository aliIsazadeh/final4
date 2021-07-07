package com.example.demo.model;
public class TimeTableBell {
    public int Id;
    public Day Day;
    public Bell Bell;
    public TimeTable TimeTable;

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
