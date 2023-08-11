package com.example.rngapp;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files; //для тестов
import java.nio.file.Paths;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;


public class Controller {
    public Controller() {
    }

    @FXML
    protected void onBtn1Click() {//первая кнопка открытие осцилографа

        File file = new File("C:\\Program Files (x86)\\Oscilloscope\\Oscilloscope.exe");//путь к осцилографу
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    @FXML
    protected void onBtn2Click(){ // считывание данных с ардуин

    }
    @FXML
    protected void onBtn3Click() throws IOException {// анализ донных
        File file = new File("C:\\rngapp\\tests\\tests3.exe");//путь к осцилографу
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }
    @FXML
    protected void onBtn4Click() throws IOException{ //кодировка
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("coding.fxml"));//подключение coding.fxml
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    protected void onBtn5Click(){//передача на другой комп
    }





    @FXML
    protected void onCode1Click() {
    }
    @FXML
    protected void onCode2Click() {
    }
    @FXML
    protected void onCode3Click() {
    }
}