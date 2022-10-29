package com.example.trosyproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertController {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int id;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setInfo(String password,String email,String name,String surname,int id){
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.email=email;
        this.id=id;
    }

    @FXML
    void egirl(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("liza.fxml"));
        root=loader.load();
        HumanController controller=loader.getController();
        controller.setInfo(password,email,name,surname,id);
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void haik(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("haik.fxml"));
        root=loader.load();
        HumanController controller=loader.getController();
        controller.setInfo(password,email,name,surname,id);
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
    }
}
