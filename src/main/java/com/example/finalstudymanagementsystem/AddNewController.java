package com.example.finalstudymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddNewController {

    @FXML ComboBox<String>  examType = new ComboBox<>();
    @FXML ComboBox<String> semester = new ComboBox<>();
    @FXML DatePicker startDate = new DatePicker();
    @FXML DatePicker endDate = new DatePicker();
    @FXML Label description = new Label();

    private ObservableList<String> examList = FXCollections.observableArrayList("Final", "Midterm",
            "Midterm 2", "Language Exam", "Placement Test", "Quiz");
    private ObservableList<String> semesterList = FXCollections.observableArrayList("Fall",
            "Spring", "Winter", "Summer", "Short");

    public void initialize(){
        examType.setItems(examList);
        semester.setItems(semesterList);
    }

    public void addButton(ActionEvent actionEvent) {
        String examTypeString = examType.getSelectionModel().getSelectedItem();
        String semesterString = semester.getSelectionModel().getSelectedItem();
        LocalDate startDateValue = startDate.getValue();
        String startDateString = startDateValue.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate endDateValue = endDate.getValue();
        String endDateString = endDateValue.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String descriptionText = description.getText();

        System.out.println(examTypeString);
        System.out.println(semesterString);
        System.out.println(startDateString);
        System.out.println(endDateString);
        System.out.println(descriptionText);
    }

    public void cancelButton(ActionEvent actionEvent) {
        Controller.getStage().close();
    }
}
