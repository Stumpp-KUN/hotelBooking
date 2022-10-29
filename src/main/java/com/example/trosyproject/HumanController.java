package com.example.trosyproject;

import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.GetAllPassDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HumanController {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int id;
    CountDB countDB=new CountDB();
    GetAllPassDB getAllPassDB=new GetAllPassDB();

    public void setInfo(String password,String email,String name,String surname,int id){
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.email=email;
        this.id=id;
        ecoType.setText(String.valueOf(countDB.getEco(id)));
        standType.setText(String.valueOf(countDB.getStand(id)));
        biznesType.setText(String.valueOf(countDB.getBiznes(id)));
    }

    @FXML
    private Label detail;

    @FXML
    private Label biznesType;

    @FXML
    private Label ecoType;

    @FXML
    private Label standType;

    @FXML
    void nhelp(MouseEvent event) throws SQLException {
        System.out.println("fds");
        getAllPassDB.alert(password);
        detail.setText("Запрос оставлен. Скоро с вами свяжутся");
    }

}
