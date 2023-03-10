package com.example.finalstudymanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class EditImageController {
    private int previousImageIndex = 0;
    private int tempImageIndex = 0;
    private final ArrayList<Image> studyImages = new ArrayList<>();
    private static Image studyImage = new Image("study3.png");

    public void initialize(){
        studyImages.add(new Image("study3.png"));
        studyImages.add(new Image("exam.png"));
        studyImages.add(new Image("music-notes.png"));
        studyImages.add(new Image("book2.png"));
        studyImages.add(new Image("classroom.png"));
        studyImages.add(new Image("bioinformatics.png"));
        studyImages.add(new Image("student.png"));
        studyImages.add(new Image("desk.png"));

        //Controller controller = new Controller();
        //controller.getStudyImage().setImage(studyImage);
        //studyImage.setImage(image);
    }

    public void changeImage0(MouseEvent event) {
        //studyImage.setImage(studyImages.get(0));
        //image = studyImages.get(0);
        //Controller.setStudyImage(studyImages.get(0));
        setStudyImage(studyImages.get(0));
        tempImageIndex = 0;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage1(MouseEvent event) {
        //studyImage.setImage(studyImages.get(1));
        //image = studyImages.get(1);
        //Controller.setStudyImage(studyImages.get(1));
        setStudyImage(studyImages.get(1));
        tempImageIndex = 1;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage2(MouseEvent event) {
        //studyImage.setImage(studyImages.get(2));
        //Controller.setStudyImage(studyImages.get(2));
        setStudyImage(studyImages.get(2));
        tempImageIndex = 2;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage3(MouseEvent event) {
        //studyImage.setImage(studyImages.get(3));
        //Controller.setStudyImage(studyImages.get(3));
        setStudyImage(studyImages.get(3));
        tempImageIndex = 3;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage4(MouseEvent event) {
        //studyImage.setImage(studyImages.get(4));
        //Controller.setStudyImage(studyImages.get(4));
        setStudyImage(studyImages.get(4));
        tempImageIndex = 4;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage5(MouseEvent event) {
        //studyImage.setImage(studyImages.get(5));
        //Controller.setStudyImage(studyImages.get(5));
        setStudyImage(studyImages.get(5));
        tempImageIndex = 5;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage6(MouseEvent event) {
        //studyImage.setImage(studyImages.get(6));
        //Controller.setStudyImage(studyImages.get(6));
        setStudyImage(studyImages.get(6));
        tempImageIndex = 6;
        //ControllerMediator.controllerSetImageView();
    }
    public void changeImage7(MouseEvent event) {
        //studyImage.setImage(studyImages.get(7));
        //Controller.setStudyImage(studyImages.get(7));
        setStudyImage(studyImages.get(7));
        tempImageIndex = 7;
        //ControllerMediator.controllerSetImageView();
    }

    public void applyButton(ActionEvent event) {
        //ControllerMediator.controllerSetImageView();

        previousImageIndex = tempImageIndex;
        //Controller.getChangeImageStage().close();
    }

    private void setStudyImage(Image image){
        studyImage = image;
    }

    public Image getImageSelected() {
        return studyImage;
    }

    public void cancelButton(ActionEvent event) {
        //Controller.getChangeImageStage().close();
    }
}
