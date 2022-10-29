package com.example.trosyproject.mail;

import com.example.trosyproject.Controller;
import com.example.trosyproject.DB.CountDB;
import com.example.trosyproject.DB.DropDB;
import com.example.trosyproject.DB.InsertBiznesDB;
import com.example.trosyproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Random;


public class MailController {


    @FXML
    private TextField code;

    @FXML
    private Button okbutn;

    @FXML
    private Button okbutn1;

    @FXML
    private Label otpr;

    private String name;
    private String surname;
    private String password;
    private String email5;
    private int id5;
    private int k;
    private int cost;

    public void setInfo(String password,String email,String name,String surname,int id,int k,int cost){
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.email5=email;
        this.id5=id;
        this.k=k;
        this.cost=cost;
    }

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

    @FXML
    void code(MouseEvent event) throws MessagingException, IOException {
        otpr.setText("Отправлено!");
    final Properties properties=new Properties();
        properties.load(new FileInputStream("D:\\javaprop\\mail.properties"));
    Session mailSession=Session.getDefaultInstance(properties);
    MimeMessage message=new MimeMessage(mailSession);
    message.setFrom(new InternetAddress("myemail"));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(email5));
    message.setSubject("Отель Rakuzan");
    message.setText("Ваш айди для бронирования: "+id);

        Transport tr= mailSession.getTransport();
        // введите тут ваш пароль от почты
        tr.connect(null,"appkxqrtgpxwqcxj");
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
            InsertBiznesDB insertBiznesDB=new InsertBiznesDB();
            insertBiznesDB.insertBiznes(name,surname,email5,password,id5,k,cost);
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
