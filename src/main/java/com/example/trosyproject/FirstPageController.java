package com.example.trosyproject;

import com.example.trosyproject.DB.GetAllPassDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class FirstPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField emailA;

    @FXML
    private TextField passwordA;

    @FXML
    private Label invalidDetails;

    private String email;
    private String password;



    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    protected
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");


    @FXML
    void author(MouseEvent event) throws SQLException, IOException {
        if (emailA.getText().isBlank() || passwordA.getText().isBlank()) {
            invalidDetails.setStyle(errorMessage);

            if (emailA.getText().isBlank()&&passwordA.getText().isBlank()) {
                invalidDetails.setText("Insert info!");
                emailA.setStyle(errorStyle);
                passwordA.setStyle(errorStyle);


            } else if (emailA.getText().isBlank()) {
                emailA.setStyle(errorStyle);
                invalidDetails.setText("Email is required!");
                passwordA.setStyle(successStyle);

            } else if (passwordA.getText().isBlank()) {
                passwordA.setStyle(errorStyle);
                invalidDetails.setText("Password is required!");
                emailA.setStyle(successStyle);
            }

        } else if (passwordA.getText().length() < 5) {
            invalidDetails.setText("name can't be less than 5 characters!");
            invalidDetails.setStyle(errorMessage);
            passwordA.setStyle(errorStyle);
        }
        else{
            ArrayList<String> allpass=new ArrayList<>();
            ArrayList<String> allemail=new ArrayList<>();
            GetAllPassDB gab=new GetAllPassDB();
            allpass=gab.getAll();
            allemail= gab.getAllEmail();
            for(int i=0;i< allemail.size();i++){
                for(int j=0;j<allpass.size();j++){
                    if(allpass.get(j).equals(passwordA.getText())&&allemail.get(i).equals(emailA.getText())){
                        String emailF=emailA.getText();
                        String passwordF=passwordA.getText();
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("hello-view.fxml"));
                        root=loader.load();
                        Controller controller=loader.getController();
                        controller.setInfo(passwordF,emailF);
                        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene=new Scene(root);
                        stage.setScene(scene);
                        break;
                    }
                }
            }
            invalidDetails.setText("НЕВЕРНАЯ ПОЧТА ИЛИ ПАРОЛЬ");

        }

    }


    @FXML
    void reg(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("regUser.fxml"));
        root=loader.load();
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
    }
}
