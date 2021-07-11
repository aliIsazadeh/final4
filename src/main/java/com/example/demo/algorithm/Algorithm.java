package com.example.demo.algorithm;

import com.example.demo.model.*;


import java.util.ArrayList;
import java.util.List;

public class Algorithm {


    public static List<TimeTable> timeTables = new ArrayList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        List<TimeTableBell> timeTableBells = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Master> masters = new ArrayList<>();
        TimeTableBell timeTableBell;
        //saturday
        timeTableBell = new TimeTableBell(new Day(0), new Bell(0));//0
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(0), new Bell(1));//1
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(0), new Bell(2));//2
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(0), new Bell(3));//3
        timeTableBells.add(timeTableBell);
        //sunday
        timeTableBell = new TimeTableBell(new Day(1), new Bell(0));//4
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(1), new Bell(1));//5
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(1), new Bell(2));//6
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(1), new Bell(3));//7
        timeTableBells.add(timeTableBell);
        //monday
        timeTableBell = new TimeTableBell(new Day(2), new Bell(0));//8
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(2), new Bell(1));//9
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(2), new Bell(2));//10
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(2), new Bell(3));//11
        timeTableBells.add(timeTableBell);
        //tuesday
        timeTableBell = new TimeTableBell(new Day(3), new Bell(0));//12
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(3), new Bell(1));//13
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(3), new Bell(2));//14
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(3), new Bell(3));//15
        timeTableBells.add(timeTableBell);
        //wednesday
        timeTableBell = new TimeTableBell(new Day(4), new Bell(0));//16
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(4), new Bell(1));//17
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(4), new Bell(2));//18
        timeTableBells.add(timeTableBell);
        timeTableBell = new TimeTableBell(new Day(4), new Bell(3));//19
        timeTableBells.add(timeTableBell);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Course course;
        course = new Course(3, "برنامه نویس پیشرفته");//0
        courses.add(course);
        course = new Course(2, "اندیشه اسلامی");//1
        courses.add(course);
        course = new Course(3, "محاسبات عددی");//2
        courses.add(course);
        course = new Course(3, "جبر خطی");//3
        courses.add(course);
        course = new Course(3, "آمار مهندسی");//4
        courses.add(course);
        course = new Course(3, "مبانی برنامه نویسی");//5
        courses.add(course);
        course = new Course(3, "طراحی الکوریتم");//6
        courses.add(course);
        course = new Course(3, "سیستم عامل");//7
        courses.add(course);
        course = new Course(3, "ریزپردازنده");//8
        courses.add(course);
        course = new Course(3, "معماری کامپیوتر");//9
        courses.add(course);
        course = new Course(1, "آز کامپیوتر");//10
        courses.add(course);
        course = new Course(3, "مدار های الکتریکی و الکتورنیکی");//11
        courses.add(course);
        course = new Course(3, "مدار منطقی");//12
        courses.add(course);
        course = new Course(1, "کارگاه برنامه نویسی");//13
        courses.add(course);
        course = new Course(2, "تاریخ اسلام");//14
        courses.add(course);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Master master;
        master = new Master("پاشا زاده");
        master.setCourses(new ArrayList<Course>());
        master.setTimeTableBells(new ArrayList<>());
        master.setTimeTable(new ArrayList<>());
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(0).clone());//sa 1
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(1).clone());//sa 2
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(2).clone());//sa 3
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(3).clone());// sa 4
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(12).clone());// tu 1
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(13).clone());//tu 2
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(9).clone());//tu 3
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(16).clone());//tu 4
        master.getCourses().add(courses.get(14));
        master.getCourses().add(courses.get(5));
        master.getCourses().add(courses.get(0));


        masters.add(master);


        master = new Master("تنها");
        master.setCourses(new ArrayList<Course>());
        master.setTimeTableBells(new ArrayList<>());
        master.setTimeTable(new ArrayList<>());

        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(0).clone());//sa 1
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(2).clone());//sa 3
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(5).clone());//su 2
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(6).clone());//su 3
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(16).clone());//we 1
        master.getTimeTableBells().add((TimeTableBell) timeTableBells.get(19).clone());//we 4
        master.getCourses().add(courses.get(0));
        master.getCourses().add(courses.get(5));
        masters.add(master);
        getFinalTimeTable(courses, timeTableBells, masters);
//
        for (TimeTable timeTable : timeTables) {
            System.out.println(timeTable.toString());
        }

    }







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
