package com.example.trosyproject.DB;

import java.sql.*;
import java.util.ArrayList;

public class CancelDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<String> checkPass(int x) throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, password);
        Statement statement = connection.createStatement();
        ArrayList<String> rn= new ArrayList<>();
        switch (x){
            case 0:{
                ResultSet resultSet = statement.executeQuery("select * from econom");
                while (resultSet.next()) {
                    rn.add(resultSet.getString("password"));
                }
                return rn;
            }
            case 1:{
                ResultSet resultSet = statement.executeQuery("select * from normal");
                while (resultSet.next()) {
                    rn.add(resultSet.getString("password"));
                }
                return rn;
            }
            case 2:{
                ResultSet resultSet = statement.executeQuery("select * from biznes");
                while (resultSet.next()) {
                    rn.add(resultSet.getString("password"));
                }
                return rn;
            }

        }
        return null;
    }

}
