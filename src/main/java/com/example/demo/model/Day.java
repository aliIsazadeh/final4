package com.example.demo.model;
public class Day {
    public int Id;
    public String Label;
    public String dayOfWeek;

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
    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(String DOW) {
        this.dayOfWeek = DOW;
    }


}
