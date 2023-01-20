package com.example.finalstudymanagementsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Course {
    private final String courseName;
    private final String place;
    private final String time;
    private final Date date;
    private int preparation = 0;
    private final int credit;
    private final ArrayList<File> studyFiles = new ArrayList<>();

    Course(String courseName, String place, String time, Date date,  int credit){
        this.courseName = courseName;
        this.place = place;
        this.time = time;
        this.date = date;
        this.credit = credit;
    }

    public String getCourseName(){
        return courseName;
    }
    public String getPlace(){
        return place;
    }
    public String getTime(){
        return time;
    }
    public Date getDate(){
        return date;
    }
    public int getPreparation(){
        return preparation;
    }
    public int getCredit(){
        return credit;
    }

    public void setPreparation(int preparation){
        this.preparation = preparation;
    }
    public void addFile(File file){
        this.studyFiles.add(file);
    }
}
