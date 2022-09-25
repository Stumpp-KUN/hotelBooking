package com.example.trosyproject;

import com.example.trosyproject.DB.CountDB;
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
import java.sql.SQLException;

public class RegController {

    private int econom=400;
    private int foodc=100;
    private int room=3;
    public int id=0;

    @FXML
    private CheckBox bed;
    boolean bed1=false;

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
    private Label cost;
    int cost1=0;

    @FXML
    private CheckBox food;
    boolean food1=false;

    @FXML
    private CheckBox people;
    boolean people1=false;

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
        fprice=econom;
        if(food.isSelected()){
            fprice+=foodc;
            cost.setText(String.valueOf(fprice)+"$");
            food1=true;
        }
        else if(!food.isSelected()){
            fprice=econom;
            cost.setText(String.valueOf(fprice)+"$");
        }

        if(bed.isSelected()){
            fprice+=75;
            cost.setText(String.valueOf(fprice)+"$");
            bed1=true;
        }


        if(people.isSelected()){
            fprice+=150;
            cost.setText(String.valueOf(fprice)+"$");
            people1=true;
        }


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


            else {
            CountDB db=new CountDB();
            InsertEcoDB db1=new InsertEcoDB();
            int x=db.getCount(0);
            name1=name.getText();
            surname1=surname.getText();
            number1=number.getText();
            email1=email.getText();
            food1=food.isSelected();
            people1=people.isSelected();
            bed1=bed.isSelected();
            MailController ml=new MailController();
            String password= String.valueOf(ml.passgen());
            boolean alert=false;
            if(x<30){
                alert=false;
                mailLoader(event, x);
                id=db1.insertEco(name1,surname1,number1,email1,people1,food1,bed1,password,alert,fprice);
            }
            else
                error();
            }


    }

    public static void mailLoader(MouseEvent event, int x) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mail.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage=new Stage();
        stage.setTitle("Пройдите авторизацию");
        stage.setScene(scene);
        stage.show();
        x++;
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void error() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("error.fxml"));
        Scene scene = new Scene(fxmlLoader1.load(), 600, 400);
        Stage stage1=new Stage();
        stage1.setTitle("ERROR");
        stage1.setScene(scene);
        stage1.show();
    }




}
