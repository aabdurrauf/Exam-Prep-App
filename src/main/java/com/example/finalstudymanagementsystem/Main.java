package com.example.finalstudymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static final BorderPane root = new BorderPane();
    private static final Image icon = new Image("study3.png");

    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void init(){

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane homePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home_page.fxml")));
        root.setCenter(homePage);
        primaryStage.setTitle("Exam Studying Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void setCenterRoot(Node node){
        root.setCenter(node);
    }

    public static void main(String[] args) {
        launch();
    }
}

/*
* https://www.flaticon.com/free-icon/study_4090395?related_id=4090394&origin=search
* */