package com.example.finalstudymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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
    private HBox hbox = new HBox();

    ExamPaneController(String examText, String dateText){
        status.setText("In Prep");
        statusIcon.setImage(new Image("load.png"));
        examLabel.setText(examText);
        dateLabel.setText(dateText);
        hbox.getChildren().addAll(status, statusIcon);
        grid.add(hbox, 0,0);
        grid.add(examLabel, 0, 1);
        grid.add(dateLabel, 0, 2);

    }

    public void setStatus(String statusText){
        this.status.setText(statusText);
    }
}
