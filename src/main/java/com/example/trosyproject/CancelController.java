package com.example.trosyproject;

import com.example.trosyproject.DB.CancelDB;
import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.DropDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CancelController{

    @FXML
    private Label d1;

    @FXML
    private Label succ;

    @FXML
    private Label biznesCount;

    @FXML
    private Label ecoCount;

    @FXML
    private Label normCount;

    private String name;
    private String surname;
    private String password;
    private String email;
    private int id;
    private int k;
    DropDB dropDB=new DropDB();
    CountDB countDB=new CountDB();

    public void setInfo(String password,String email,String name,String surname,int id){
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.email=email;
        this.id=id;
        setAll();

    }

    public void setAll(){
        CountDB countDB=new CountDB();
        System.out.println(password);
        ecoCount.setText(String.valueOf(countDB.getEco(this.id)));
        normCount.setText(String.valueOf(countDB.getStand(this.id)));
        biznesCount.setText(String.valueOf(countDB.getBiznes(this.id)));
    }

    @FXML
    void BiznesCancel(MouseEvent event) throws SQLException {
        if(countDB.getBiznes(id)>0) {
            dropDB.dropBiznes(id);
            succ.setText("Бронь успешно удалена");
            biznesCount.setText(String.valueOf(countDB.getBiznes(id)));
        }
        else
            succ.setText("Ошибка! Вы не забронированы");
    }

    @FXML
    void Ecocancel(MouseEvent event) throws SQLException {
        if(countDB.getEco(id)>0) {
            dropDB.dropECO(id);
            succ.setText("Бронь успешно удалена");
            ecoCount.setText(String.valueOf(countDB.getEco(id)));
        }
        else
            succ.setText("Ошибка! Вы не забронированы");
    }

    @FXML
    void Stcancel(MouseEvent event) throws SQLException {
        if(countDB.getStand(id)>0) {
            dropDB.dropNorm(id);
            succ.setText("Бронь успешно удалена");
            normCount.setText(String.valueOf(countDB.getStand(id)));
        }
        else
            succ.setText("Ошибка! Вы не забронированы");
    }



}
