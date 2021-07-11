package com.example.demo.model;
public class Day {
    public int Id;
    public String Label;
    public int dayOfWeek;

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public String getLabel() {
        return this.Label;
    }

    public void setLabel(String label) {
        this.Label = label;
    }
    public int getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(int DOW) {
        this.dayOfWeek = DOW;
    }

    public Day(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Day() {
    }


}
