package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
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
    @FXML ListView materialsList;
    @FXML Label warningLabel;

    public void addButton(ActionEvent actionEvent) {
        String courseNameString;
        if (!courseName.getText().isBlank()){
            courseNameString = courseName.getText();
        }
        else {
            warningLabel.setText("Please enter a valid course name");
        }
        int creditInt;
        try{
            creditInt = Integer.parseInt(credit.getText());
        }
        catch (NumberFormatException e) {
            warningLabel.setText("Please enter a valid credit value");
        }
        String teacherString;
        if (!teacher.getText().isBlank()){
            teacherString = teacher.getText();
        }
        String examPlaceString;
        if (!examPlace.getText().isBlank()){
            examPlaceString = examPlace.getText();
        }
        String examTimeString;
        if (!examTime.getText().isBlank()){
            examTimeString = examTime.getText();
        }
        LocalDate examDateLD;
        if (!examDate.getValue().toString().isBlank()){
            examDateLD = examDate.getValue();
        }
        try {
            ArrayList<String> materialsArrayList = new ArrayList<String>((Collection<? extends String>) materialsList);
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
