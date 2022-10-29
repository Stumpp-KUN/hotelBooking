package com.example.trosyproject;

import com.example.trosyproject.DB.RegUserDB;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.SQLException;

public class RegUserContoller {
    @FXML
    private TextField emailT;

    @FXML
    private TextField nameT;

    @FXML
    private TextField passwordT;

    @FXML
    private TextField phoneT;

    @FXML
    private TextField surnameT;

    @FXML
    private Label invalidDetails;

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @FXML
    void RegButton(MouseEvent event) throws SQLException {
        if (nameT.getText().isBlank() || surnameT.getText().isBlank()||phoneT.getText().isBlank()||emailT.getText().isBlank()) {
            invalidDetails.setStyle(errorMessage);

            if (nameT.getText().isBlank() && surnameT.getText().isBlank()&&phoneT.getText().isBlank()&&emailT.getText().isBlank()) {
                invalidDetails.setText("Insert info!");
                nameT.setStyle(errorStyle);
                surnameT.setStyle(errorStyle);
                phoneT.setStyle(errorStyle);
                emailT.setStyle(errorStyle);


            } else if (nameT.getText().isBlank()) {
                nameT.setStyle(errorStyle);
                invalidDetails.setText("Name is required!");
                surnameT.setStyle(successStyle);
                phoneT.setStyle(successStyle);
                emailT.setStyle(successStyle);


            } else if (surnameT.getText().isBlank()) {
                surnameT.setStyle(errorStyle);
                invalidDetails.setText("Surname is required!");
                nameT.setStyle(successStyle);
                phoneT.setStyle(successStyle);
                emailT.setStyle(successStyle);
            }
            else if (phoneT.getText().isBlank()) {
                phoneT.setStyle(errorStyle);
                invalidDetails.setText("Number is required!");
                nameT.setStyle(successStyle);
                surnameT.setStyle(successStyle);
                emailT.setStyle(successStyle);
            }
            else if (emailT.getText().isBlank()) {
                emailT.setStyle(errorStyle);
                invalidDetails.setText("Email is required!");
                nameT.setStyle(successStyle);
                surnameT.setStyle(successStyle);
                phoneT.setStyle(successStyle);
            }
        } else if (passwordT.getText().length() < 5) {
            invalidDetails.setText("Password can't be less than 5 characters!");
            invalidDetails.setStyle(errorMessage);
            passwordT.setStyle(errorStyle);
        }
        else{
           SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
           try{
               Session session=factory.getCurrentSession();
               String name=nameT.getText();
               String surname=surnameT.getText();
               String phone=phoneT.getText();
               String email=emailT.getText();
               String password=passwordT.getText();
               RegUserDB regUserDB=new RegUserDB(name,surname,phone,email,password,false,0);
               session.beginTransaction();
               session.save(regUserDB);
               session.getTransaction().commit();
               invalidDetails.setText("ВЫ УСПЕШНО ЗАРЕГЕСТРИРОВАЛИСЬ");
           }
           finally {
               factory.close();
           }

        }



    }
}
