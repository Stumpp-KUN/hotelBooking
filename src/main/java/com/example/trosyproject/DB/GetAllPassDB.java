package com.example.trosyproject.DB;

import java.sql.*;
import java.util.ArrayList;

public class GetAllPassDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<String> getAll() throws SQLException{
        connection = DriverManager.getConnection(URL, LOGIN, password);
        Statement statement = connection.createStatement();
        ArrayList<String> rn= new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from econom");
        while (resultSet.next())
            rn.add(resultSet.getString("password"));
        resultSet = statement.executeQuery("select * from biznes");
        while (resultSet.next())
            rn.add(resultSet.getString("password"));
        resultSet = statement.executeQuery("select * from normal");
        while (resultSet.next())
            rn.add(resultSet.getString("password"));
        return rn;
    }

    public void alert(String pass,int x) throws SQLException {
        String sql="";
        switch (x){
            case 0:{
                sql = "UPDATE `econom` set alert=true WHERE password=?";
            }
            break;
            case 1:{
                sql = "UPDATE `normal` set alert=true WHERE password=?";
            }
            break;
            case 2:{
                sql = "UPDATE `biznes` set alert=true WHERE password=?";
            }
            break;
        }
        connection = DriverManager.getConnection(URL, LOGIN, password);
        PreparedStatement statement1=connection.prepareStatement(sql);
        statement1.setString(1,pass);
        statement1.executeUpdate();

    }
}
