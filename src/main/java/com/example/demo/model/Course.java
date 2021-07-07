package com.example.demo.model;
import java.util.List;

public class Course {
    public int Id;
    public String Title;
    public int UnitsCount;
    public List<TimeTable> TimeTables;
    public List<Master> Masters;

    public int getId() {
        return this.Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String TT) {
        this.Title = TT;
    }

    public int getUnitsCount() {
        return this.UnitsCount;
    }

    public void setUnitsCount(int UC) {
        this.UnitsCount = UC;
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
