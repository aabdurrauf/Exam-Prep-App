package com.example.finalstudymanagementsystem;

import java.util.ArrayList;
import java.util.Date;

public class Exam {
    private final String examType;
    private final String examSemester;
    private final Date examDateStart;
    private final Date examDateEnd;
    private final ArrayList<Course> courses = new ArrayList<>();

    Exam(String examType, String examSemester, Date examDateStart, Date examDateEnd){
        this.examType = examType;
        this.examSemester = examSemester;
        this.examDateStart = examDateStart;
        this.examDateEnd = examDateEnd;
    }

    public String getExamType() {
        return examType;
    }
    public String getExamSemester(){
        return examSemester;
    }
    public Date getExamDateStart() {
        return examDateStart;
    }
    public Date getExamDateEnd() {
        return examDateEnd;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}