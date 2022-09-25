package com.example.trosyproject;

import com.example.trosyproject.DB.AdminDB;
import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.InsertEcoDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController{

    @FXML
    private TextField name;

    @FXML
    private TextField pass;

    @FXML
    void autor(MouseEvent event) throws SQLException, IOException {
        AdminDB adb=new AdminDB();
        ArrayList<String> name1=new ArrayList<>();
        ArrayList<String> password=new ArrayList<>();
        name1=adb.allNames();
        password=adb.allPasswords();

        for(int i=0;i< name1.size();i++){
            if(name.getText().equals(name1.get(i))){
                if(pass.getText().equals(password.get(i))) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-panel.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                    Stage stage = new Stage();
                    stage.setTitle("Панель администратора");
                    stage.setScene(scene);
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
            }
        }
    }
}
