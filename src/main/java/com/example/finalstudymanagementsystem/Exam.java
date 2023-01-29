package com.example.finalstudymanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Exam {
    private final String examType;
    private final String examSemester;
    private final LocalDate examDateStart;
    private final LocalDate examDateEnd;
    private final ArrayList<Course> courses = new ArrayList<>();

    Exam(String examType, String examSemester, LocalDate examDateStart, LocalDate examDateEnd){
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
    public LocalDate getExamDateStart() {
        return examDateStart;
    }
    public LocalDate getExamDateEnd() {
        return examDateEnd;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}