package com.example.trosyproject;

import com.example.trosyproject.DB.DropDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Приветствуем ВАС в отеле RAKUZAN!");
        stage.setScene(scene);
        stage.show();
    }

  public static void main(String[] args) {

        launch();
      }

}
