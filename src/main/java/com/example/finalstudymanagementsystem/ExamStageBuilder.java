package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ExamStageBuilder extends AnchorPane {
    BorderPane root;
    AnchorPane topPane;
    AnchorPane leftPane;
    AnchorPane centerPane;
    Label titleLabel = new Label();
    private static ArrayList<String> examMaterialsList = new ArrayList<>();

    public ExamStageBuilder(String titleString, String dateString) {
        root = new BorderPane();
        leftPane = new AnchorPane();
        centerPane = new AnchorPane();
        Font font = Font.font("Gadugi", FontWeight.BOLD, FontPosture.REGULAR, 29);
        Font font2 = Font.font("System", FontWeight.BOLD, FontPosture.REGULAR, 12);

        // setting the top
        topPane = new AnchorPane();
        titleLabel.setText(titleString);
        titleLabel.setFont(font);
        ImageView editLabelIcon = new ImageView(new Image("edit.png"));
        editLabelIcon.setFitHeight(15);
        editLabelIcon.setPreserveRatio(true);
        editLabelIcon.setLayoutY(21);
        editLabelIcon.setCursor(Cursor.HAND);
        editLabelIcon.setOnMouseClicked(this::editLabel); // bu ne ?? :)
        HBox topVBox = new HBox();
        AnchorPane imagePane = new AnchorPane();
        imagePane.getChildren().add(editLabelIcon);
        topVBox.getChildren().addAll(titleLabel, imagePane);
        topVBox.setSpacing(10);
        Label dateLabel = new Label(dateString);
        dateLabel.setFont(font2);
        dateLabel.setStyle("-fx-text-fill: #5e503f");
        Button addCourseButton = new Button("Add Course");
        addCourseButton.setStyle("-fx-background-color: #D9C5AE");
        addCourseButton.setFont(font2);
        addCourseButton.setCursor(Cursor.HAND);
        addCourseButton.setOnAction(this::addCourse);
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #D9C5AE");
        deleteButton.setFont(font2);
        deleteButton.setCursor(Cursor.HAND);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(addCourseButton, deleteButton);
        buttons.setSpacing(10);
        VBox topGroup = new VBox();
        topGroup.getChildren().addAll(topVBox, dateLabel, buttons);
        topGroup.setSpacing(5);
        topPane.getChildren().add(topGroup);
        topGroup.setLayoutX(47);
        topGroup.setLayoutY(19);
        root.setTop(topPane);
        topPane.setPrefWidth(879);
        topPane.setPrefHeight(150);
        topPane.setStyle("-fx-background-color: #EAE0D5");

        // setting the left
        VBox vbox = new VBox();
        Label examSchedule = new Label("Exam Schedule");
        setLabelStyle(examSchedule);
        examSchedule.setOnMouseClicked(e -> System.out.println("examSchedule clicked") /* opening the center scene */);
        Label studySchedule = new Label("Study Schedule");
        setLabelStyle(studySchedule);
        studySchedule.setOnMouseClicked(e -> System.out.println("studySchedule clicked") /* opening the center scene */);
        Label examMaterials = new Label("Exam Materials");
        setLabelStyle(examMaterials);
        Label examResults = new Label("Exam Results");
        setLabelStyle(examResults);
        examResults.setOnMouseClicked(e -> System.out.println("examResults clicked") /* opening the center scene */);
        vbox.getChildren().addAll(examSchedule, studySchedule, examMaterials);
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
        leftPane.getChildren().add(vbox);
        leftPane.setPrefWidth(178);
        leftPane.setPrefHeight(424);
        leftPane.setStyle("-fx-background-color: #EAE0D5");
        root.setLeft(leftPane);

        // center pane
        //centerPane.setPrefWidth(605);
        //centerPane.setPrefHeight(424);
        root.setCenter(centerPane);

        // root
        root.setPrefWidth(879);
        root.setPrefHeight(574);
        getChildren().add(root);
    }

    private static final Stage editLabelStage = new Stage();
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

        TextField textField = new TextField(titleLabel.getText());
        textField.setPrefWidth(250);
        Button change = new Button("Change");
        Button cancel = new Button("Cancel");
        change.setBackground(bg2);
        cancel.setBackground(bg2);
        change.setOnAction(e -> {
            String text = textField.getText();
            if (text.length() <= 25) {
                titleLabel.setText(textField.getText());
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

    private static final Stage addNewCourse = new Stage();
    public static Stage getAddNewCourse(){
        return addNewCourse;
    }
    public void addCourse(ActionEvent actionEvent) {
        // pop up new stage to add nwe course
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_new_course.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image icon = new Image("book.png");

        addNewCourse.setTitle("Add Course");
        addNewCourse.setScene(new Scene(pane));
        addNewCourse.getIcons().add(icon);
        addNewCourse.show();
        addNewCourse.setResizable(false);

        /*Label courseName = new Label("Course Name");
        Label teacher = new Label("Teacher");
        Label credit = new Label("Credit");
        Label examPlace = new Label("Exam Place");
        Label examDate = new Label("Exam Date");
        Label examTime = new Label("Exam Time");

        TextField courseNameTF = new TextField();
        TextField teacherTF = new TextField();
        TextField creditTF = new TextField();
        TextField examPlaceTF = new TextField();
        DatePicker examDatePicker = new DatePicker();
        DatePicker examTimeDate = new DatePicker();
        //examTimeDate.*/
    }

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
}
