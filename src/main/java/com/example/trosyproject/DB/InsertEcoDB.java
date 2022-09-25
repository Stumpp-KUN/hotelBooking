package com.example.trosyproject.DB;

import java.sql.*;
import java.util.ArrayList;

public class InsertEcoDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password1 = "root";
    CountDB cn=new CountDB();
    int x=cn.getCount(0);

    private Connection connection;

    public InsertEcoDB() throws SQLException {
    }

    public Connection getConnection() {
        return connection;
    }

    public int insertEco(String name, String surname, String phone, String email, boolean people, boolean food, boolean bed, String password, boolean alert, int cost) throws SQLException {
        x++;
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="INSERT INTO `econom` (name,surname,phone,email,people,food,bed,password,alert,id,cost,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,surname);
        pstmt.setString(3,phone);
        pstmt.setString(4,email);
        if(people==true)
        pstmt.setBoolean(5,true);
        else
            pstmt.setBoolean(5,false);
        if(food==true)
            pstmt.setBoolean(6,true);
        else
            pstmt.setBoolean(6,false);
        if(bed==true)
            pstmt.setBoolean(7,true);
        else
            pstmt.setBoolean(7,false);
        pstmt.setString(8,password);
        pstmt.setBoolean(9,false);
        pstmt.setInt(10,x);
        pstmt.setInt(11,cost);
        pstmt.setString(12,"Econom-класс");
        pstmt.executeUpdate();
        return x;
    }

    public ArrayList<String> getName() throws SQLException {
        ArrayList<String> rn=new ArrayList<>();
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from econom");
        while (resultSet.next())
            rn.add(resultSet.getString("name"));
        resultSet = statement.executeQuery("select * from biznes");
        while (resultSet.next())
            rn.add(resultSet.getString("name"));
        resultSet = statement.executeQuery("select * from normal");
        while (resultSet.next())
            rn.add(resultSet.getString("name"));
        return rn;
    }

    public ArrayList<String> getSurname() throws SQLException {
        ArrayList<String> rn=new ArrayList<>();
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from econom");
        while (resultSet.next())
            rn.add(resultSet.getString("surname"));
        resultSet = statement.executeQuery("select * from biznes");
        while (resultSet.next())
            rn.add(resultSet.getString("surname"));
        resultSet = statement.executeQuery("select * from normal");
        while (resultSet.next())
            rn.add(resultSet.getString("surname"));
        return rn;
    }

    public ArrayList<String> getEmail() throws SQLException {
        ArrayList<String> rn=new ArrayList<>();
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from econom");
        while (resultSet.next())
            rn.add(resultSet.getString("email"));
        resultSet = statement.executeQuery("select * from biznes");
        while (resultSet.next())
            rn.add(resultSet.getString("email"));
        resultSet = statement.executeQuery("select * from normal");
        while (resultSet.next())
            rn.add(resultSet.getString("email"));
        return rn;
    }


}
