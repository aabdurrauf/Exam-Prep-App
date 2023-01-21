package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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


public class Controller {
    private static final Stage stage = new Stage();
    private static ArrayList<ExamPaneController> ExamPanesArrayList = new ArrayList<>();

    public static Stage getStage() {
        return stage;
    }

    public static ArrayList<ExamPaneController> getExamPanesArrayList() {
        return ExamPanesArrayList;
    }

    @FXML
    Label Label1;
    public void editLabel(MouseEvent mouseEvent) {
        Image icon = new Image("pencils.png");
        Stage stage = new Stage();
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
                stage.close();
            }
            else {
                label2.setText("Maximum 25 characters");
            }
        });
        cancel.setOnAction(e -> {
            stage.close();
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

        stage.setTitle("Change Label");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void addNew(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_new.fxml")));
        Image icon = new Image("book (1).png");

        stage.setTitle("Add New Exam");
        stage.setScene(new Scene(pane));
        stage.getIcons().add(icon);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private AnchorPane anchorPane;
    private static GridPane gridPane = new GridPane();
    public void initialize() {
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setPadding(new Insets(10));
        anchorPane.getChildren().add(gridPane);
    }

    public static GridPane getGridPane(){
        return gridPane;
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void notification(MouseEvent mouseEvent) {
    }
}