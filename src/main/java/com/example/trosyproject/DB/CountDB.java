package com.example.trosyproject.DB;

import com.mysql.fabric.jdbc.FabricMySQLConnection;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

public class CountDB {
    private final String URL = "jdbc:mysql://localhost:3306/apartments";
    private final String LOGIN = "root";
    private final String password = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public int getCount(int k) throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, password);
        Statement statement = connection.createStatement();
        switch (k) {
            case 0: {
                ResultSet rs = statement.executeQuery("select count(*) from econom");
                rs.next();
                int count = rs.getInt(1);
                return count;
            }
            case 1:{
                ResultSet rs = statement.executeQuery("select count(*) from normal");
                rs.next();
                int count = rs.getInt(1);
                return count;
            }
            case 2:{
                ResultSet rs = statement.executeQuery("select count(*) from biznes");
                rs.next();
                int count = rs.getInt(1);
                return count;
            }
        }

        return 0;
    }




}
