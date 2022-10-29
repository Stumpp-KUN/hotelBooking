package com.example.trosyproject;

import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.mail.MailController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AppartmentsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    CountDB countDB=new CountDB();

    @FXML
    private Label biznesI;

    @FXML
    private Label ecoI;

    @FXML
    private Label standartE;

    @FXML
    private Label econE;

    @FXML
    private Label biznesE;

    @FXML
    private Label standI;

    private String name;
    private String surname;
    private String password;
    private String email;
    private int id;

    public void setInfo(String password,String email,String name,String surname,int id){
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.email=email;
        this.id=id;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ecoI.setText("Занято "+countDB.getCount(0)+" мест");
            standI.setText("Занято "+countDB.getCount(1)+" мест");
            biznesI.setText("Занято "+countDB.getCount(2)+" мест");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void biznes(MouseEvent event) throws IOException, SQLException {
        int k = 2;
        int cost=1400;

       if(countDB.getCount(k)<5) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mail.fxml"));
            root = loader.load();
            MailController controller = loader.getController();
            controller.setInfo(password, email, name, surname, id, k,cost);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
        else {
            biznesE.setText("Закончились свободные места");
        }
    }

    @FXML
    void econ(MouseEvent event) throws IOException, SQLException {
        int cost=400;
        int k = 0;
        if(countDB.getCount(k)<30) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mail.fxml"));
            root = loader.load();
            MailController controller = loader.getController();
            controller.setInfo(password, email, name, surname, id, k,cost);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
        else {
            econE.setText("Закончились свободные места");
        }
    }

    @FXML
    void standart(MouseEvent event) throws IOException, SQLException {
        int cost=800;
        int k = 1;
        if(countDB.getCount(k)<10) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mail.fxml"));
            root = loader.load();
            MailController controller = loader.getController();
            controller.setInfo(password, email, name, surname, id, k,cost);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
        else {
            standartE.setText("Закончились свободные места");
        }
    }
}
