package com.example.trosyproject;

import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.InsertNormalDB;
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

public class Reg1Controller {

    private int standart=800;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox bed;
    boolean bed1=false;

    @FXML
    private CheckBox client;
    boolean client1=false;

    @FXML
    private Label cost;

    @FXML
    private CheckBox food;
    boolean food1=false;

    @FXML
    private CheckBox pet;
    boolean pet1=false;

    @FXML
    private CheckBox pool;
    boolean pool1=false;

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
    private Label invalidDetails;

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");


    public int fprice;
    @FXML
    void initialize() {
        fprice=standart;
        if(food.isSelected()) {
            fprice += 100;
            cost.setText(String.valueOf(fprice) + "$");
        }
        if(pet.isSelected()){
            fprice+=75;
            cost.setText(String.valueOf(fprice)+ "$");
        }
        if(pool.isSelected()){
            fprice+=90;
            cost.setText(String.valueOf(fprice)+"$");
        }
        if(client.isSelected()){
            fprice+=50;
            cost.setText(String.valueOf(fprice)+ "$");
        }
        if(bed.isSelected()){
            fprice+=65;
            cost.setText(String.valueOf(fprice)+ "$");
        }
        cost.setText(String.valueOf(fprice)+ "$");

    }

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
    else{
        CountDB db=new CountDB();
        InsertNormalDB db1=new InsertNormalDB();
        int x=db.getCount(1);
        name1=name.getText();
        surname1=surname.getText();
        number1=number.getText();
        email1=email.getText();
        food1=food.isSelected();
        pet1=pet.isSelected();
        client1=client.isSelected();
        pool1=pool.isSelected();
        bed1=bed.isSelected();
        MailController ml=new MailController();
        String password= String.valueOf(ml.passgen());
        boolean alert=false;
        if(x<10){
            RegController.mailLoader(event, x);
            db1.insertNorm(name1,surname1,number1,email1,food1,pet1,bed1,pool1,client1,alert,password);
        }
        else{
            RegController error=new RegController();
            error.error();

        }

    }

    }




}
