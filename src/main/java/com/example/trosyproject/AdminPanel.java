package com.example.trosyproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {

    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password1 = "root";

    @FXML
    private TableColumn<User, String> email1;

    @FXML
    private TableColumn<User, Integer> id1;

    @FXML
    private TableColumn<User, String> type1;

    @FXML
    private TableColumn<User,String> name1;

    @FXML
    private TableColumn<User, String> surname1;

    @FXML
    private TableColumn<User, Boolean> alert1;

    @FXML
    private TableView<User> table;

    private ObservableList<User> observableList;

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void populateTable() throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        observableList= FXCollections.observableArrayList();
        String sql="SELECT * FROM biznes";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            User mealTableModel = new User();
            mealTableModel.setId(resultSet.getInt("id"));
            mealTableModel.setName(resultSet.getString("name"));
            mealTableModel.setSurname(resultSet.getString("surname"));
            mealTableModel.setEmail(resultSet.getString("email"));
            mealTableModel.setAlert(resultSet.getBoolean("alert"));
            mealTableModel.setType(resultSet.getString("type"));
            observableList.add(mealTableModel);
        }

        sql="SELECT * FROM normal";
        resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            User mealTableModel = new User();
            mealTableModel.setId(resultSet.getInt("id"));
            mealTableModel.setName(resultSet.getString("name"));
            mealTableModel.setSurname(resultSet.getString("surname"));
            mealTableModel.setEmail(resultSet.getString("email"));
            mealTableModel.setType(resultSet.getString("type"));
            mealTableModel.setAlert(resultSet.getBoolean("alert"));
            observableList.add(mealTableModel);
        }

        sql="SELECT * FROM econom";
        resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            User mealTableModel = new User();
            mealTableModel.setId(resultSet.getInt("id"));
            mealTableModel.setName(resultSet.getString("name"));
            mealTableModel.setSurname(resultSet.getString("surname"));
            mealTableModel.setEmail(resultSet.getString("email"));
            mealTableModel.setType(resultSet.getString("type"));
            mealTableModel.setAlert(resultSet.getBoolean("alert"));
            observableList.add(mealTableModel);
        }

        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname1.setCellValueFactory(new PropertyValueFactory<>("surname"));
        email1.setCellValueFactory(new PropertyValueFactory<>("email"));
        type1.setCellValueFactory(new PropertyValueFactory<>("type"));
         alert1.setCellValueFactory(new PropertyValueFactory<>("alert"));

        table.setEditable(true);
        table.setItems(observableList);

    }
}
