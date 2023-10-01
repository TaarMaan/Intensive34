package ru.aston.artamonov_va.task1.task4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionConnector {

    private ConnectionConnector() {
    }

    public static Connection getConnection() throws SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.username");
        String password = resourceBundle.getString("db.password");


        return DriverManager.getConnection(url, user, password);
    }
}