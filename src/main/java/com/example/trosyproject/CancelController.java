package com.example.trosyproject;

import com.example.trosyproject.DB.CancelDB;
import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.DropDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CancelController implements Initializable {


    @FXML
    private ChoiceBox<String> apptype;

    @FXML
    private Label d1;

    @FXML
    private TextField pass1;

    private String[] apartments={"econom","normal","biznes"};

    @FXML
    void cancel(MouseEvent event) throws SQLException {

        CancelDB can=new CancelDB();
        ArrayList<String> pass=new ArrayList<>();
        if(apptype.getValue()=="econom"){
            pass=can.checkPass(0);
            for(int i=0;i<pass.size();i++){
                if(pass1.getText().equals(pass.get(i))){
                    DropDB db=new DropDB();
                    db.dropEP(pass.get(i));
                    d1.setText("Успешно");
                }
                else
                    d1.setText("Error");
            }
        }
        else if(apptype.getValue()=="normal"){
            pass=can.checkPass(1);
            for(int i=0;i<pass.size();i++){
                if(pass1.getText().equals(pass.get(i))){
                    DropDB db=new DropDB();
                    db.dropNP(pass.get(i));
                    d1.setText("Успешно");
                }
                else
                    d1.setText("Error");
            }
        }
        else if(apptype.getValue()=="biznes"){
            pass=can.checkPass(2);
            for(int i=0;i<pass.size();i++){
                if(pass1.getText().equals(pass.get(i))){
                    DropDB db=new DropDB();
                    db.dropBP(pass.get(i));
                    d1.setText("Успешно");
                }
                else
                    d1.setText("Error");
            }
        }
        else{
            d1.setText("Error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apptype.getItems().addAll(apartments);

    }
}
