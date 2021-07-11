package com.example.demo.algorithm;

import com.example.demo.model.*;


import java.util.ArrayList;
import java.util.List;

public class algorithm {
    public static List<TimeTable> timeTables = new ArrayList<>();
    public static void selectTimeTable(Course course, List<TimeTableBell> timeTableBells, Master master) {

        //for each unit one class
        for (int i = 0; i < course.getUnitsCount(); i++) {
            boolean selectTimeTable = false;


            for (TimeTableBell masterTimeTableBell : master.getTimeTableBells() ) {
                //is master have other class in same time
                if (masterTimeTableBell.isSelected())
                    continue;

                for (TimeTableBell timeTableBell : timeTableBells) {

                    //is selected time table bell same ass master time table bell
                    if (masterTimeTableBell.getDay() == timeTableBell.getDay() && masterTimeTableBell.getBell() == timeTableBell.getBell()) {
                        //
                        TimeTable timeTable = new TimeTable();
                        timeTable.setCourse(course);
                        timeTable.setMasters(master);
                        //master cant have same class in one day
                        if (!isDuplicateClassInDay(master.getTimeTable(), masterTimeTableBell, course)) {
                            if (master.getTimeTable().size() > 0) {
                                // whitOut have same course in a day
                                timeTable.setTimeTableBells(timeTableBell);
                                masterTimeTableBell.setSelected(true);
                                timeTables.add(timeTable);
                                master.getTimeTable().add(timeTable);
                                selectTimeTable = true;
                                break;

                            } else {
                                timeTable.setTimeTableBells(timeTableBell);
                                masterTimeTableBell.setSelected(true);
                                timeTables.add(timeTable);
                                master.getTimeTable().add(timeTable);
                                selectTimeTable = true;
                                break;
                            }
                        }
                    }
                }
                if (selectTimeTable)
                    break;

            }

        }


    }
    public static boolean isDuplicateClassInDay(List<TimeTable> masterTimeTable, TimeTableBell currentTimeTableBell, Course course) {
        for (TimeTable timeTable : masterTimeTable) {
            if (timeTable.course.getTitle().equals(course.getTitle()) && timeTable.getTimeTableBell().getDay().getDayOfWeek() == currentTimeTableBell.getDay().getDayOfWeek())
                return true;
        }
        return false;

    }

    public static boolean isValidCourse(Course masterSelectedCourse, List<Course> currentCourses) {
        for (Course currentCourse : currentCourses) {
            if (currentCourse.getTitle().equals(masterSelectedCourse.getTitle()))
                return true;
        }
        return false;
    }
    //start method
    public static void getFinalTimeTable(List<Course> courses, List<TimeTableBell> timeTableBells, List<Master> masters) {
        for (Master master : masters) {
            for (Course masterSelectedCourse : master.getCourses()) {
                if (isValidCourse(masterSelectedCourse, courses)) {
                    selectTimeTable(masterSelectedCourse, timeTableBells, master);

                }
            }
        }


    }
}
