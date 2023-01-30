package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddNewCourseController {
    @FXML TextField courseName;
    @FXML TextField credit;
    @FXML TextField teacher;
    @FXML TextField examPlace;
    @FXML TextField examTime;
    @FXML DatePicker examDate;
    @FXML Label warningLabel;

    public void addButton(ActionEvent actionEvent) {
        String courseNameString;
        if (!courseName.getText().equals("")){
            courseNameString = courseName.getText();
        }
        else {
            warningLabel.setText("Please enter a valid course name");
        }
        //if (credit.getText())
    }


}
