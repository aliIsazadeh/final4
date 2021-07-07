package com.example.demo.model;

import java.util.List;

public class Student {
    public int Id;
    public List<TimeTable> TimeTables;
    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }
    public List getTimeTable() {
        return this.TimeTables;
    }

    public void setTimeTable(List TT) {
        this.TimeTables = TT;
    }


}
