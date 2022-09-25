package com.example.trosyproject.DB;

import java.sql.*;

public class InsertNormalDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password1 = "root";
    CountDB cn=new CountDB();
    int x=cn.getCount(1);

    private Connection connection;

    public InsertNormalDB() throws SQLException{

    }

    public Connection getConnection() {
        return connection;
    }

    public int insertNorm(String name,String surname,String phone,String email,boolean food,boolean pet,boolean bed,boolean pool,boolean client,boolean alert, String password) throws SQLException {
        x++;
        connection = DriverManager.getConnection(URL, LOGIN, password1);
        Statement statement = connection.createStatement();
        String sql="INSERT INTO `normal` (name,surname,phone,email,food,pet,bed,pool,help,alert,password,id,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,surname);
        pstmt.setString(3,phone);
        pstmt.setString(4,email);
        pstmt.setBoolean(5,food);
        pstmt.setBoolean(6,pet);
        pstmt.setBoolean(7,bed);
        pstmt.setBoolean(8,pool);
        pstmt.setBoolean(9,client);
        pstmt.setBoolean(10,alert);
        pstmt.setString(11,password);
        pstmt.setInt(12,x);
        pstmt.setString(13,"Normal-класс");
        pstmt.executeUpdate();

        return x;
    }



}
