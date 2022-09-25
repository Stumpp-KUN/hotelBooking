package com.example.trosyproject.DB;

import java.sql.*;

public class DropDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password1 = "root";
    int x=0;

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void dropECO(int id) throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `econom` WHERE id=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setInt(1,id);
        statement1.executeUpdate();
    }

    public void dropNorm(int id) throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `normal` WHERE id=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setInt(1,id);
        statement1.executeUpdate();
    }

    public void dropBiznes(int id) throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `biznes` WHERE id=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setInt(1,id);
        statement1.executeUpdate();
    }
    public void dropEP(String pass) throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `econom` WHERE password=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setString(1,pass);
        statement1.executeUpdate();
    }

    public void dropNP(String pass) throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `normal` WHERE password=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setString(1,pass);
        statement1.executeUpdate();
    }

    public void dropBP(String pass) throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="DELETE FROM `biznes` WHERE password=?";
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setString(1,pass);
        statement1.executeUpdate();
    }
}
