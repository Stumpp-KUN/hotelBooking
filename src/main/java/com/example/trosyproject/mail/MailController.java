package com.example.trosyproject.mail;

import com.example.trosyproject.Controller;
import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.DropDB;
import com.example.trosyproject.DB.InsertEcoDB;
import com.example.trosyproject.DB.InsertNormalDB;
import com.example.trosyproject.HelloApplication;
import com.example.trosyproject.RegController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Random;


public class MailController {

    @FXML
    private TextField email;

    @FXML
    private TextField code;

    @FXML
    private Button okbutn;

    @FXML
    private Button okbutn1;

    @FXML
    private AnchorPane mailwin;

    public int wh;

    public void setWh(int wh){
        this.wh=wh;
    }

    boolean check=false;
    String ty="";

    public boolean getCheck(){
        return check;
    }

    Random random=new Random();
    String id = String.format("%04d", random.nextInt(10000));





    public char[] passgen(){
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters  + numbers;
        int length=5;
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));
        for(int i = 3; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    @FXML
    void code(MouseEvent event) throws MessagingException, IOException {
    final Properties properties=new Properties();
        properties.load(new FileInputStream("D:\\javaprop\\mail.properties"));

    Session mailSession=Session.getDefaultInstance(properties);
    MimeMessage message=new MimeMessage(mailSession);
    message.setFrom(new InternetAddress("myemail"));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getText()));
    message.setSubject("Отель Rakuzan");
    String pass= String.valueOf(passgen());
    ty=pass;
    message.setText("Ваш айди для бронирования: "+id+". Пароль: "+pass);

        Transport tr= mailSession.getTransport();
        // введите тут ваш пароль от почты
        tr.connect(null,"");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();
    }

    @FXML
    void broon(MouseEvent event) throws IOException, SQLException {
        int x=Integer.parseInt(code.getText());
        int y=Integer.parseInt(id);
        if(x==y){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("confirm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 100);
            Stage stage=new Stage();
            stage.setTitle("Вы успешно забронировали номер!");
            stage.setScene(scene);
            stage.show();
            Controller chc=new Controller();


            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else{
            mailerror();
            CountDB countDB=new CountDB();
            DropDB dropDB=new DropDB();
            dropDB.dropECO(countDB.getCount(0));
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    private void mailerror() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mailerror.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 100);
        Stage stage=new Stage();
        stage.setTitle("Ошибка");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ok(MouseEvent event) throws SQLException {
        check=true;

        okbutn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage) okbutn.getScene().getWindow()).close();
            }
        });
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void ok1(MouseEvent event) {
        check=false;
        okbutn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage) okbutn1.getScene().getWindow()).close();
            }
        });
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }




}
