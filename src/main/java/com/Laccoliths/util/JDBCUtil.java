package com.Laccoliths.util;

import java.sql.*;

public class JDBCUtil {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://121.36.86.90:3306/petsystem";
    private static String user = "root";
    private static String password = "Zx102020!";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet, PreparedStatement preparedStatement){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
