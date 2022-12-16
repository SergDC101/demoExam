package com.example.demoexam;

import java.sql.*;

public class ConnectDB {

    Connection dbConnect;

    String userDB = "root";
    String passDB = "359678";


    public Connection getConnect() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3307/examtest";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnect = DriverManager.getConnection(connectionString, userDB, passDB);
        return dbConnect;
    }



    public ResultSet getUser(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        String select = "SELECT * FROM examtest.wokers where login = '"+login+"' and password = '"+password+"'";
        PreparedStatement preparedStatement = getConnect().prepareStatement(select);
        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }




}
