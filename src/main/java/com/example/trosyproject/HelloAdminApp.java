package com.example.trosyproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloAdminApp extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.trosyproject.HelloApplication.class.getResource("admin-panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("База данных отеля");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {

            launch();
        }
}
