package com.example.trosyproject;

import com.example.trosyproject.DB.RegUserDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {

    @FXML
    private TableColumn<RegUserDB, String> email1;

    @FXML
    private TableColumn<RegUserDB, Integer> id1;

    @FXML
    private TableColumn<RegUserDB,String> name1;

    @FXML
    private TableColumn<RegUserDB, String> surname1;

    @FXML
    private TableColumn<RegUserDB, Boolean> alert1;

    @FXML
    private TableView<RegUserDB> table;

    private ObservableList<RegUserDB> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void populateTable() throws SQLException{
        observableList= FXCollections.observableArrayList();
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Biznes.class).addAnnotatedClass(Normal.class).addAnnotatedClass(Econom.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<Biznes> biznes=session.createQuery(" from Biznes ").getResultList();

        for(int i=0;i<biznes.size();i++) {
            RegUserDB regUserDB=session.get(RegUserDB.class,biznes.get(i).getId());
            observableList.add(regUserDB);
        }
        observableList.add(null);

        List<Normal> norm=session.createQuery(" from Normal ").getResultList();
        for(int i=0;i<norm.size();i++) {
            RegUserDB regUserDB=session.get(RegUserDB.class,norm.get(i).getId());
            observableList.add(regUserDB);
        }
        observableList.add(null);

        List<Econom> eco=session.createQuery(" from Econom ").getResultList();
        for(int i=0;i<eco.size();i++) {
            RegUserDB regUserDB=session.get(RegUserDB.class,eco.get(i).getId());
            observableList.add(regUserDB);
        }

        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname1.setCellValueFactory(new PropertyValueFactory<>("surname"));
        email1.setCellValueFactory(new PropertyValueFactory<>("email"));
         alert1.setCellValueFactory(new PropertyValueFactory<>("alert"));

        table.setEditable(true);
        table.setItems(observableList);
        session.getTransaction().commit();
        factory.close();

    }
}
