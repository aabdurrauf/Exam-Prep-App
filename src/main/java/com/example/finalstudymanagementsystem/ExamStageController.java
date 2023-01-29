package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExamStageController implements Initializable {
    @FXML
    AnchorPane menuLeftPane;
    // this ArrayList can be initialized or can be added new course later
    ArrayList<String> examMaterialsList = new ArrayList<>();

    private static void setLabelStyle(Label label){
        Font font = Font.font("System", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        label.setFont(font);
        label.setCursor(Cursor.HAND);
        label.setStyle("-fx-background-radius: 10");

        label.setPrefHeight(40);
        label.setPrefWidth(200);
        label.setPadding(new Insets(10));
        label.setOnMouseEntered(e -> label.setStyle("-fx-background-color: #D9C5AE"));
        label.setOnMouseExited(e -> label.setStyle("-fx-background-color: #EAE0D5"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VBox vbox = new VBox();

        Label examSchedule = new Label("Exam Schedule");
        setLabelStyle(examSchedule);

        Label studySchedule = new Label("Study Schedule");
        setLabelStyle(studySchedule);

        Label examMaterialsLabel = new Label("Exam Materials");
        setLabelStyle(examMaterialsLabel);

        Label examResults = new Label("Exam Results");
        setLabelStyle(examResults);

        vbox.getChildren().addAll(examSchedule, studySchedule, examMaterialsLabel);

        if (examMaterialsList.size() > 0) {
            Separator horizontalSeparator = new Separator();
            vbox.getChildren().add(horizontalSeparator);

            for (String material : examMaterialsList){
                Label materialLabel = new Label(material);
                setLabelStyle(materialLabel);
                vbox.getChildren().add(materialLabel);
            }

            Separator horizontalSeparator2 = new Separator();
            vbox.getChildren().add(horizontalSeparator2);
        }
        vbox.getChildren().add(examResults);

        vbox.setSpacing(10);
        vbox.setPrefWidth(200);
        menuLeftPane.getChildren().add(vbox);
    }

    private static final Stage editLabelStage = new Stage();
    @FXML Label Label1;
    public void editLabel(MouseEvent mouseEvent) {
        Image icon = new Image("pencils.png");
        AnchorPane pane = new AnchorPane();

        Background bg1 = new Background(new BackgroundFill(Color.rgb(234, 224, 213),
                new CornerRadii(0), new Insets(0)));
        Background bg2 = new Background(new BackgroundFill(Color.rgb(217, 197, 174),
                new CornerRadii(5), new Insets(0)));
        Font font = Font.font("System", FontWeight.LIGHT, FontPosture.ITALIC, 11);

        Label label = new Label("Set Label:");
        Label label2 = new Label("");
        label2.setFont(font);

        TextField textField = new TextField(Label1.getText());
        textField.setPrefWidth(250);
        Button change = new Button("Change");
        Button cancel = new Button("Cancel");
        change.setBackground(bg2);
        cancel.setBackground(bg2);
        change.setOnAction(e -> {
            String text = textField.getText();
            if (text.length() <= 25) {
                Label1.setText(textField.getText());
                editLabelStage.close();
            }
            else {
                label2.setText("Maximum 25 characters");
            }
        });
        cancel.setOnAction(e -> {
            editLabelStage.close();
        });
        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(10);
        buttonsBox.getChildren().addAll(label2, change, cancel);
        GridPane grid = new GridPane();
        grid.add(label, 0, 0);
        grid.add(textField, 0, 1);
        grid.add(buttonsBox, 0, 2);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
        grid.setBackground(bg1);
        Scene scene = new Scene(pane);
        //scene.setFill(Color.rgb(234, 224, 213));
        pane.getChildren().add(grid);

        editLabelStage.setTitle("Change Label");
        editLabelStage.getIcons().add(icon);
        editLabelStage.setScene(scene);
        editLabelStage.show();
        editLabelStage.setResizable(false);
    }

    public void addNew(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void notification(MouseEvent mouseEvent) {
    }
}