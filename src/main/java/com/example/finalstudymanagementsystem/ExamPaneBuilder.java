package com.example.finalstudymanagementsystem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExamPaneBuilder extends AnchorPane {
    private VBox vbox = new VBox();
    private GridPane grid = new GridPane();
    private Label status = new Label();
    private ImageView statusIcon = new ImageView();
    private Label examLabel = new Label();
    private Label dateLabel = new Label();
    private Label descriptionLabel = new Label();
    private HBox hbox = new HBox();
    private ArrayList<Label> courses = new ArrayList<>();
    private Background bg = new Background(new BackgroundFill(Color.rgb(234, 224, 213),
            new CornerRadii(10), new Insets(0)));
    private Font font1 = Font.font("System", FontWeight.BOLD, FontPosture.REGULAR, 10);
    private Font font2 = Font.font("System", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 12);
    private Font font3 = Font.font("System", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10);
    private Font font4 = Font.font("System", FontWeight.LIGHT, FontPosture.ITALIC, 10);
    private ExamStageBuilder examStage;

    ExamPaneBuilder(String examText, String dateText, String descriptionText){
        examStage = new ExamStageBuilder(examText, dateText);
        status.setText("In Prep");
        status.setFont(font1);
        statusIcon.setImage(new Image("load.png", 12, 12, true, true));
        examLabel.setText(examText);
        examLabel.setFont(font2);
        dateLabel.setText(dateText);
        dateLabel.setFont(font3);
        descriptionLabel.setText(descriptionText);
        descriptionLabel.setFont(font4);
        hbox.getChildren().addAll(status, statusIcon);
        hbox.setSpacing(5);
        hbox.setAlignment(Pos.TOP_RIGHT);
        /*grid.add(hbox, 0,0);
        grid.add(examLabel, 0, 1);
        grid.add(dateLabel, 0, 2);
        grid.add(descriptionLabel, 0, 3);
        grid.setBackground(bg);
        grid.setPadding(new Insets(10));
        grid.setPrefSize(120, 160);
        */
        vbox.getChildren().addAll(hbox, examLabel, dateLabel, descriptionLabel);
        vbox.setSpacing(2);
        vbox.setBackground(bg);
        vbox.setPadding(new Insets(10));
        vbox.setPrefSize(120, 160);

        getChildren().add(vbox);

        // set mouse action to the pane
        Stage stage = new Stage();
        Scene scene = new Scene(examStage);
        setOnMouseClicked(e -> {
            try {
                System.out.println(examText + " clicked");

                Image icon = new Image("pencils.png");
                stage.setTitle(examText);
                stage.getIcons().add(icon);
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
                // end of test
            }
            catch (IllegalArgumentException ex){
                System.out.println("the stage already opened");
            }
        });
    }

    public void setStatus(String statusText){
        this.status.setText(statusText);
    }
}
