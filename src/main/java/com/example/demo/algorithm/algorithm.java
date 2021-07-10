package com.example.demo.algorithm;

import com.example.demo.model.Course;
import com.example.demo.model.Master;
import com.example.demo.model.TimeTable;
import com.example.demo.model.TimeTableBell;

import java.util.ArrayList;
import java.util.List;

public class algorithm {
    public static List<TimeTable> timeTables = new ArrayList<>();
    public static void selectTimeTable(Course course, List<TimeTableBell> timeTableBells, Master master) {

        for (int i = 0; i < course.getUnitsCount(); i++) {
            boolean selectTimeTable = false;

            for (TimeTableBell masterTimeTableBell : master.getTimeTableBell() ) {
                if (masterTimeTableBell.isSelected())
                    continue;
                for (TimeTableBell timeTableBell : timeTableBells) {

                    if (masterTimeTableBell.getDay() == timeTableBell.getDay() && masterTimeTableBell.getBell() == timeTableBell.getBell()) {
                        //
                        TimeTable timeTable = new TimeTable();
                        timeTable.setCourse(course);
                        timeTable.setMasters(master);
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

    public static void getFinalTimeTable(List<Course> courses, List<TimeTableBell> timeTableBells, List<Master> masters) {
        for (Master master : masters) {
            for (Course masterSelectedCourse : master.getCourse()) {
                if (isValidCourse(masterSelectedCourse, courses)) {
                    selectTimeTable(masterSelectedCourse, timeTableBells, master);

                }
            }
        }


    }
}
