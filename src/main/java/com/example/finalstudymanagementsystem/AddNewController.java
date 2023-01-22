package com.example.finalstudymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddNewController {

    @FXML private ComboBox<String>  examType = new ComboBox<>();
    @FXML private ComboBox<String> semester = new ComboBox<>();
    @FXML private DatePicker startDate = new DatePicker();
    @FXML private DatePicker endDate = new DatePicker();
    @FXML private TextField description = new TextField();
    @FXML private Label warningLabel = new Label();


    private ObservableList<String> examList = FXCollections.observableArrayList("Final", "Midterm",
            "Midterm 2", "Language Test", "Placement Test", "Quiz");
    private ObservableList<String> semesterList = FXCollections.observableArrayList("Fall",
            "Spring", "Winter", "Summer", "Short");

    public void initialize(){
        examType.setItems(examList);
        semester.setItems(semesterList);
    }

    public void addButton(ActionEvent actionEvent) {
        try {
            String examTypeString = examType.getSelectionModel().getSelectedItem();
            String semesterString = semester.getSelectionModel().getSelectedItem();
            if (examTypeString == null || semesterString == null) {
                throw new NullPointerException();
            }

            LocalDate startDateValue = startDate.getValue();
            StringBuilder startDateString = new StringBuilder(startDateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            LocalDate endDateValue = endDate.getValue();
            String endDateString = endDateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String descriptionText = description.getText();

            String examLabel = examTypeString + " " + semesterString; // + " '" + startDateString.substring(startDateString.length() - 2, startDateString.length());
            String dateText = startDateString.substring(0, startDateString.length() - 5) + " - " +
                    endDateString;

            ExamPaneController examPane = new ExamPaneController(examLabel, dateText, descriptionText);
            Controller.getExamPanesArrayList().add(examPane);

            Controller.getGridPane().add(examPane, (Controller.getExamPanesArrayList().size() - 1) % 4,
                    (Controller.getExamPanesArrayList().size()-1) / 4);
            Controller.getAddNewStage().close();
        }
        catch (NullPointerException e){
            warningLabel.setText("Please select the necessary items :)");
        }



        /*System.out.println(examTypeString);
        System.out.println(semesterString);
        System.out.println(startDateString);
        System.out.println(endDateString);
        System.out.println(descriptionText);*/
    }

    public void cancelButton(ActionEvent actionEvent) {
        Controller.getAddNewStage().close();
    }
}
