package ru.aston.morozov_aa.task4.work_with_db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource {
    private static DataSource dataSource;
    private Connection connection;

    private String url;
    private String password;
    private String username;
    private String driver;

    private DataSource(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

        this.url = resourceBundle.getString("url");
        this.password = resourceBundle.getString("password");
        this.username = resourceBundle.getString("username");
        this.driver = resourceBundle.getString("driver");

        try {

            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static synchronized DataSource getInstance(){
        if(dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public synchronized Connection getConnection(){

        try {
            if(connection.isClosed() || connection == null){
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
