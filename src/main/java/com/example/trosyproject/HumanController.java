package com.example.trosyproject;

import com.example.trosyproject.DB.GetAllPassDB;
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

public class HumanController implements Initializable {
    @FXML
    private ChoiceBox<String> apptype;

    @FXML
    private Label answer;

    @FXML
    private TextField passhelp;

    private String[] apartments={"econom","normal","biznes"};

    @FXML
    void nhelp(MouseEvent event) throws SQLException {
        ArrayList<String> allpass=new ArrayList<>();
        GetAllPassDB gab=new GetAllPassDB();
        allpass=gab.getAll();
        for(int i=0;i<allpass.size();i++){
            if(apptype.getValue()=="econom") {
                if (passhelp.getText().equals(allpass.get(i))) {
                    gab.alert(allpass.get(i),0);
                    answer.setText("Успешно");
                }
            }
            else if(apptype.getValue()=="normal"){
                if(passhelp.getText().equals(allpass.get(i))){
                    gab.alert(allpass.get(i),1);
                    answer.setText("Успешно");
                }
            }
            else if(apptype.getValue()=="biznes"){
                if(passhelp.getText().equals(allpass.get(i))){
                    gab.alert(allpass.get(i),2);
                    answer.setText("Успешно");
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apptype.getItems().addAll(apartments);

    }
}
