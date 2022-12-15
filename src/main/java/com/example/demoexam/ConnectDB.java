package com.example.demoexam;

import java.sql.*;

public class ConnectDB {

    Connection dbConnect;


    public static final String host = "127.0.0.1";
    public static final String port = "3307";
    public static final String nameDB = "examtest";
    public static final String userDB = "root";
    public static final String passDB = "359678";


    public Connection getConnect() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" +host+ ":"
                +port+ "/" +nameDB;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnect = DriverManager.getConnection(connectionString, userDB, passDB);
        return dbConnect;
    }

    public ResultSet getUser(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM examtest.wokers where login = ? and password = ?";

        PreparedStatement preparedStatement = getConnect().prepareStatement(select);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2,password);
        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }




}
