package com.example.trosyproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {
    private int ap;
    public int getAp(){
        return ap;
    }

    @FXML
    private AnchorPane ap1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button apartments;

    @FXML
    private Button infoid;

    @FXML
    void appbtn(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("apartments.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        Stage stage=new Stage();
        stage.setTitle("Наши номера");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void infobtn(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage=new Stage();
        stage.setTitle("Информация о нас");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void quitask(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void cancel(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cancel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage=new Stage();
        stage.setTitle("Отмена брони");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void admin(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage=new Stage();
        stage.setTitle("Авторизация администратора");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void biznes(MouseEvent event) throws IOException {
//метод проверки места
        ap=2;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bronirovanie2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage=new Stage();
        stage.setTitle("Бронирование места");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void econ(MouseEvent event) throws IOException {
//метод проверки места
        ap=0;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bronirovanie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage=new Stage();
        stage.setTitle("Бронирование места");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void standart(MouseEvent event) throws IOException {
//метод проверки места
        ap=1;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bronirovanie1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage=new Stage();
        stage.setTitle("Бронирование места");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void help(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage=new Stage();
        stage.setTitle("Помощь");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void egirl(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("liza.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 200);
        Stage stage=new Stage();
        stage.setTitle("Консультант");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void haik(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("haik.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 200);
        Stage stage=new Stage();
        stage.setTitle("Консультант");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void initialize() {

    }

}

