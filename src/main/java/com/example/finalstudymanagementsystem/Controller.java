package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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


public class Controller {
    private static final Stage addNewStage = new Stage();
    private static final Stage editLabelStage = new Stage();
    private static ArrayList<ExamPaneController> ExamPanesArrayList = new ArrayList<>();


    public static Stage getAddNewStage() {
        return addNewStage;
    }
    public static ArrayList<ExamPaneController> getExamPanesArrayList() {
        return ExamPanesArrayList;
    }

    @FXML ImageView studyImage = new ImageView();
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

/*

    private final ArrayList<Image> studyImages = new ArrayList<>();
    private static Image image = new Image("study3.png");

    int tempImageIndex = 0;
    private int previousImageIndex = 0;

    public void editImage(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_image.fxml"));
        Parent root = loader.load();
        //AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit_image.fxml")));
        Image icon = new Image("laptop.png");

        // you have to always set the image view after setting a new image
        image = new Image("desk.png");
        studyImage.setImage(image);

        // https://stackoverflow.com/questions/22178533/communication-between-two-javafx-controllers

        changeImageStage.setTitle("Change Image");
        changeImageStage.setScene(new Scene(root));
        changeImageStage.getIcons().add(icon);
        changeImageStage.show();
        changeImageStage.setResizable(false);
    }

    public void changeImage0(MouseEvent event) {
        studyImage.setImage(studyImages.get(0));
        tempImageIndex = 0;
    }
    public void changeImage1(MouseEvent event) {
        studyImage.setImage(studyImages.get(1));
        tempImageIndex = 1;
    }
    public void changeImage2(MouseEvent event) {
        studyImage.setImage(studyImages.get(2));
        tempImageIndex = 2;
    }
    public void changeImage3(MouseEvent event) {
        studyImage.setImage(studyImages.get(3));
        tempImageIndex = 3;
    }
    public void changeImage4(MouseEvent event) {
        studyImage.setImage(studyImages.get(4));
        tempImageIndex = 4;
    }
    public void changeImage5(MouseEvent event) {
        studyImage.setImage(studyImages.get(5));
        tempImageIndex = 5;
    }
    public void changeImage6(MouseEvent event) {
        studyImage.setImage(studyImages.get(6));
        tempImageIndex = 6;
    }
    public void changeImage7(MouseEvent event) {
        studyImage.setImage(studyImages.get(7));
        tempImageIndex = 7;
    }

    public void applyButton(ActionEvent event) {

        previousImageIndex = tempImageIndex;
        changeImageStage.close();
    }

    public void cancelButton(ActionEvent event) {
        Controller.getChangeImageStage().close();
    }
*/

    public void addNew(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_new.fxml")));
        Image icon = new Image("book (1).png");

        addNewStage.setTitle("Add New Exam");
        addNewStage.setScene(new Scene(pane));
        addNewStage.getIcons().add(icon);
        addNewStage.show();
        addNewStage.setResizable(false);
    }

    @FXML
    private AnchorPane anchorPane;
    private static GridPane gridPane = new GridPane();
    @FXML Button addNewButton;
    @FXML Button deleteButton;

    public void initialize(){

        try{
            gridPane.setVgap(12);
            gridPane.setHgap(12);
            gridPane.setPadding(new Insets(10));
            anchorPane.getChildren().add(gridPane);

            addNewButton.setOnMouseEntered(e -> {
                addNewButton.setStyle("-fx-background-color:  #C6AC8F");
            });
            addNewButton.setOnMouseExited(e -> {
                addNewButton.setStyle("-fx-background-color:  #D9C5AE");
            });
            deleteButton.setOnMouseEntered(e -> {
                deleteButton.setStyle("-fx-background-color: #C6AC8F");
            });
            deleteButton.setOnMouseExited(e -> {
                deleteButton.setStyle("-fx-background-color: #D9C5AE");
            });
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException");
        }
    }

    public static GridPane getGridPane(){
        return gridPane;
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void notification(MouseEvent mouseEvent) {
    }
}

/* <a href="https://www.flaticon.com/free-icons/school" title="school icons">School icons created by Eucalyp - Flaticon</a> */