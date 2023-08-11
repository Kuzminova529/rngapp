package com.example.rngapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainStage.fxml"));//подключение MainStage.fxml
        stage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/logo.png")));// иконка
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RNGapp");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}