package com.example.trosyproject.DB;

import java.sql.*;
import java.util.ArrayList;

public class AdminDB {
    private final String URL = "jdbc:mysql://localhost:3306/admin";
    private final String LOGIN = "root";
    private final String password = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<String> allNames() throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, password);
        Statement statement = connection.createStatement();
        ArrayList<String> rn = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from adminclients");
        while (resultSet.next()) {
            rn.add(resultSet.getString("name"));
        }
        return rn;
    }

    public ArrayList<String> allPasswords() throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, password);
        Statement statement = connection.createStatement();
        ArrayList<String> rn = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from adminclients");
        while (resultSet.next()) {
            rn.add(resultSet.getString("password"));
        }
        return rn;
    }

}
