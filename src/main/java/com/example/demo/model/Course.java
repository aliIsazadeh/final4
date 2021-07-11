package com.example.demo.model;
import java.util.List;

public class Course {
    public int Id;
    public String title;
    public int unitsCount;
    public List<TimeTable> TimeTables;
    public List<Master> Masters;

    public Course(int unitsCount, String title) {
        this.unitsCount = unitsCount;
        this.title = title;
    }

    public Course() {
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String TT) {
        this.title = TT;
    }

    public int getUnitsCount() {
        return this.unitsCount;
    }

    public void setUnitsCount(int UC) {
        this.unitsCount = UC;
    }

    public List getTimeTable() {
        return this.TimeTables;
    }

    public void setTimeTables(List TTE) {
        this.TimeTables = TTE;
    }


    public List getMasters() {
        return this.Masters;
    }

    public void setMasters(List MAS) {
        this.Masters = MAS;
    }

}
