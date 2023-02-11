package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddNewCourseController {
    @FXML TextField courseName;
    @FXML TextField credit;
    @FXML TextField teacher;
    @FXML TextField examPlace;
    @FXML TextField examTime;
    @FXML DatePicker examDate;
    @FXML ListView<String> materialsList;
    @FXML Label warningLabel;

    public void addButton(ActionEvent actionEvent) {
        String courseNameString = null;
        if (!courseName.getText().isBlank()){
            courseNameString = courseName.getText();
        }
        else {
            warningLabel.setText("Please enter a valid course name");
        }
        int creditInt = 0;
        try{
            creditInt = Integer.parseInt(credit.getText());
        }
        catch (NumberFormatException e) {
            warningLabel.setText("Please enter a valid credit value");
        }
        String teacherString = null;
        if (!teacher.getText().isBlank()){
            teacherString = teacher.getText();
        }
        String examPlaceString = null;
        if (!examPlace.getText().isBlank()){
            examPlaceString = examPlace.getText();
        }
        String examTimeString = null;
        if (!examTime.getText().isBlank()){
            examTimeString = examTime.getText();
        }
        LocalDate examDateLD = null;
        try{
            examDateLD = examDate.getValue();
        }
        catch (Exception e){
            System.out.println("date isn't picked");
        }
        ArrayList<String> materialsArrayList;
        try {
            // list of materials from this course
            // later will be added to Exam Materials section in Exam Stage
            materialsArrayList = new ArrayList<>((Collection<String>) materialsList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            Course course = new Course(courseNameString, examPlaceString, examTimeString, examDateLD, creditInt);
            ExamStageController.getCourseArrayList().add(course);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void browseFile(){
        FileChooser fileChooser = new FileChooser();
        try{
            fileChooser.setInitialDirectory(new File("D:\\"));
        }
        catch (Exception e){
            System.out.println("path not found");
        }
        List<File> SelectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (SelectedFiles!= null) {
            for (File selectedFile : SelectedFiles) {
                materialsList.getItems().add(selectedFile.getAbsolutePath());
            }
        }
    }

    public void cancelButton(ActionEvent actionEvent) {
        ExamStageController.getAddNewCourse().close();
    }
    /* file chooser:
    https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html*/


}
