package com.twinkleroot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/springdata";
        String url = "jdbc:postgresql://192.168.99.100:5432/springdata";
        String username = "ahn";
        String password = "pass";

        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);
//            String sql = "CREATE TABLE  ACCOUNT (id int, username varchar(255), password varchar(255));";
            String sql = "INSERT INTO ACCOUNT VALUES(1, 'ahn', 'pass');";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        }
    }
}
