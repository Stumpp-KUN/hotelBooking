package com.example.trosyproject;

import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.InsertBiznesDB;
import com.example.trosyproject.DB.InsertEcoDB;
import com.example.trosyproject.mail.MailController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Reg2Controller {

    private int biznes=1700;

    @FXML
    private Label invalidDetails;

    @FXML
    private Label cost;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;
    String email1="";

    @FXML
    private TextField name;
    String name1="";

    @FXML
    private TextField number;
    String number1="";

    @FXML
    private TextField surname;
    String surname1="";

    @FXML
    private CheckBox bed;
    boolean bed1=false;

    @FXML
    private CheckBox food;
    boolean food1=false;

    @FXML
    private CheckBox jak;
    boolean jak1=false;

    @FXML
    private CheckBox spa;
    boolean spa1=false;

    @FXML
    void initialize() {
        biznes=1700;
        if(food.isSelected()){
            biznes+=800;
            cost.setText(String.valueOf(biznes)+"$");
        }
        if(bed.isSelected()){
            biznes+=400;
            cost.setText(String.valueOf(biznes)+"$");
        }
        if(jak.isSelected()){
            biznes+=250;
            cost.setText(String.valueOf(biznes)+"$");
        }
        if(spa.isSelected()){
            biznes+=650;
            cost.setText(String.valueOf(biznes)+"$");
        }
        cost.setText(String.valueOf(biznes)+"$");

    }

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");


    @FXML
    void bron(MouseEvent event) throws IOException, SQLException {
        if (name.getText().isBlank() || surname.getText().isBlank()||number.getText().isBlank()||email.getText().isBlank()) {
            invalidDetails.setStyle(errorMessage);

            if (name.getText().isBlank() && surname.getText().isBlank()&&number.getText().isBlank()&&email.getText().isBlank()) {
                invalidDetails.setText("Insert info!");
                name.setStyle(errorStyle);
                surname.setStyle(errorStyle);
                number.setStyle(errorStyle);
                email.setStyle(errorStyle);


            } else if (name.getText().isBlank()) {
                name.setStyle(errorStyle);
                invalidDetails.setText("Name is required!");
                surname.setStyle(successStyle);
                number.setStyle(successStyle);
                email.setStyle(successStyle);


            } else if (surname.getText().isBlank()) {
                surname.setStyle(errorStyle);
                invalidDetails.setText("Surname is required!");
                name.setStyle(successStyle);
                number.setStyle(successStyle);
                email.setStyle(successStyle);
            }
            else if (number.getText().isBlank()) {
                number.setStyle(errorStyle);
                invalidDetails.setText("Number is required!");
                name.setStyle(successStyle);
                surname.setStyle(successStyle);
                email.setStyle(successStyle);
            }
            else if (email.getText().isBlank()) {
                email.setStyle(errorStyle);
                invalidDetails.setText("Email is required!");
                name.setStyle(successStyle);
                surname.setStyle(successStyle);
                email.setStyle(successStyle);
            }
        } else if (name.getText().length() < 2) {
            invalidDetails.setText("name can't be less than 2 characters!");
            invalidDetails.setStyle(errorMessage);
            name.setStyle(errorStyle);
        }


        else {
            CountDB db=new CountDB();
            InsertBiznesDB db1=new InsertBiznesDB();
            int x=db.getCount(2);
            name1=name.getText();
            surname1=surname.getText();
            number1=number.getText();
            email1=email.getText();
            food1=food.isSelected();
            jak1=jak.isSelected();
            bed1=bed.isSelected();
            spa1=spa.isSelected();
            MailController ml=new MailController();
            String password= String.valueOf(ml.passgen());
            boolean alert=false;
            if(x<5){
                RegController.mailLoader(event,x);
                db1.insertBiznes(name1,surname1,number1,email1,food1,jak1,bed1,spa1,alert,password,biznes);
            }
            else {
                RegController error = new RegController();
                error.error();
            }
        }


    }
    }

