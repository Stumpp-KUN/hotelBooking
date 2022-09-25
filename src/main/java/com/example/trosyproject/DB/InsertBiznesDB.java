package com.example.trosyproject.DB;

import java.sql.*;

public class InsertBiznesDB {

    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password1 = "root";
    CountDB cn=new CountDB();
    int x=cn.getCount(2);

    private Connection connection;

    public InsertBiznesDB() throws SQLException {
    }

    public int insertBiznes(String name,String surname,String phone,String email,boolean food, boolean jakuzi,boolean bed,boolean spa,boolean alert,String password,int cost) throws SQLException {
        x++;
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="INSERT INTO `biznes` (name,surname,phone,email,food,jakuzi,bed,spa,alert,password,id,cost,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,surname);
        pstmt.setString(3,phone);
        pstmt.setString(4,email);
        pstmt.setBoolean(5,food);
        pstmt.setBoolean(6,jakuzi);
        pstmt.setBoolean(7,bed);
        pstmt.setBoolean(8,spa);
        pstmt.setBoolean(9,alert);
        pstmt.setString(10,password);
        pstmt.setInt(11,x);
        pstmt.setInt(12,cost);
        pstmt.setString(13,"Biznes-класс");
        pstmt.executeUpdate();
        return x;
    }
}
