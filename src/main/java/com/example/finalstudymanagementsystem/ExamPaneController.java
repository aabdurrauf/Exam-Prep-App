package com.example.finalstudymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ExamPaneController extends AnchorPane {
/*

    @FXML
    Label statusLabel;
    @FXML
    ImageView statusIcon;
    @FXML
    Label examLabel;
    @FXML
    Label dateLabel;
*/

    private GridPane grid = new GridPane();
    private Label status = new Label();
    private ImageView statusIcon = new ImageView();
    private Label examLabel = new Label();
    private Label dateLabel = new Label();
    private Label descriptionLabel = new Label();
    private HBox hbox = new HBox();
    private ArrayList<Label> courses = new ArrayList<>();

    ExamPaneController(String examText, String dateText, String descriptionText){
        status.setText("In Prep");
        statusIcon.setImage(new Image("load.png", 15, 15, true, true));
        examLabel.setText(examText);
        dateLabel.setText(dateText);
        descriptionLabel.setText(descriptionText);
        hbox.getChildren().addAll(status, statusIcon);
        grid.add(hbox, 0,0);
        grid.add(examLabel, 0, 1);
        grid.add(dateLabel, 0, 2);
        grid.add(descriptionLabel, 0, 3);

        getChildren().add(grid);
    }

    public void setStatus(String statusText){
        this.status.setText(statusText);
    }
}
