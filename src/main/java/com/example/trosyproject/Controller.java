package com.example.trosyproject;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.trosyproject.DB.GetAllPassDB;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    @FXML
    private Button apartments;

    @FXML
    private Button infoid;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label hello;

    private String name;
    private String surname;
    private String email;
    private String password;
    private int id;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @FXML
    void appbtn(MouseEvent event) throws IOException, SQLException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("apartments.fxml"));
        root=loader.load();
        AppartmentsController controller=loader.getController();
        controller.setInfo(password,email,name,surname,id);
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
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
    void cancel(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("cancel.fxml"));
        root=loader.load();
        CancelController controller=loader.getController();
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        controller.setInfo(password,email,name,surname,id);
        stage.setScene(scene);
    }

    @FXML
    void help(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("help.fxml"));
        root=loader.load();
        AlertController controller=loader.getController();
        controller.setInfo(password,email,name,surname,id);
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
    }



    public void setInfo(String pass,String gmail) throws SQLException {
        email=gmail;
        password=pass;
        GetAllPassDB gap=new GetAllPassDB();
        name=gap.getName(pass);
        surname=gap.getSurname(pass);
        id=gap.getId(pass);
        hello.setText("Приветствуем, "+name+" "+surname+"!");

    }

}

