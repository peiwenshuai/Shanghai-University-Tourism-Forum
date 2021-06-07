package com.web6.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTools {
    private static DataSource dataSource;
    static {
        dataSource=new ComboPooledDataSource("test3p0");
    }
    public static Connection getConnection(){
       Connection connection=null;
       try{
           connection=dataSource.getConnection();
       }catch (SQLException e){
        e.printStackTrace();
       }
       return connection;
    }
    public static void relaese(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***public static void main(String[] args){
        System.out.println(JDBCTools.getConnection());
    }
*/
}
