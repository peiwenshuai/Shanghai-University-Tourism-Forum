package com.web6.repository.impl;

import com.web6.entity.User;
import com.web6.repository.UserRepository;
import com.web6.until.MD5Code;
import com.web6.utils.JDBCTools;

import java.sql.*;
import java.time.DateTimeException;

public class UserRepositoryImpl implements UserRepository {
   @Override
   public User FindUser(Integer id,String username, String password
           ,Integer type
           ,String email,String head_url){
       Connection connection= JDBCTools.getConnection();

       String sql="select * from user where name = ?";
       PreparedStatement statement=null;
       ResultSet resultSet=null;
       User user=null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setString(1,username);
           resultSet = statement.executeQuery();
           if(resultSet.next()){

               user=new User(resultSet.getInt(1),resultSet.getString(2)
                       ,resultSet.getString(3),resultSet.getInt(4),
                       resultSet.getString(5),resultSet.getString(6));
           }
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           JDBCTools.relaese(connection,statement,resultSet);
       }
       return user;
   }

    @Override
    public User login(Integer id,String username, String password
            ,Integer type
            ,String email,String head_url)  {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from user where name = ? and password = ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1,username);
            statement.setString(2,password);

            resultSet = statement.executeQuery();

            if(resultSet.next()){

                user=new User(resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,statement,resultSet);
        }

        return user;
    }

    @Override
    public User regist(Integer id, String username, String password,
                       Integer type, String email, String head_url) {


         Connection connection_r = JDBCTools.getConnection();

            String sql_r = "INSERT INTO user(name,password,type,email,photo,create_time) VALUES(?,?,1,?,?,now())";

            PreparedStatement statement_r = null;
            User user_r = null;
            try {
                statement_r = connection_r.prepareStatement(sql_r);

                password=new MD5Code().getMD5ofStr(password);
                statement_r.setString(1, username);
                statement_r.setString(2, password);
                statement_r.setString(3, email);
                statement_r.setString(4, head_url);

                statement_r.executeUpdate();
                if(statement_r!=null){
                    System.out.println(email);

                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCTools.relaese(connection_r, statement_r,null);
            }

        user_r=new User(id, username, password, type, email, head_url);
        return user_r;
    }

    @Override
    public User repassword(Integer id, String username, String password, Integer type, String email, String head_url) {
        Connection connection_u = JDBCTools.getConnection();


        String sql_u = "UPDATE user SET password= ? WHERE name= ?";

        PreparedStatement statement_u = null;

        try {
            statement_u = connection_u.prepareStatement(sql_u);

            password=new MD5Code().getMD5ofStr(password);
            System.out.println(password);
            statement_u.setString(1, password);
            statement_u.setString(2, username);


            statement_u.executeUpdate();
            if(statement_u!=null){
                System.out.println(username);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_u, statement_u,null);
        }
        User user_u = new User(id, username, password, type, email, head_url);

        return user_u;
    }


    @Override
    public User uploadimg(Integer id, String username, String password, Integer type, String email, String head_url) {
        Connection connection_u = JDBCTools.getConnection();
        String sql_u = "UPDATE user SET photo= ? WHERE name= ?";

        User user_p = null;
        PreparedStatement statement_u = null;

        try {
            statement_u = connection_u.prepareStatement(sql_u);

            statement_u.setString(1, head_url);
            statement_u.setString(2, username);


            statement_u.executeUpdate();
            if(statement_u!=null){
                System.out.println(username);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_u, statement_u,null);
        }
         user_p = new User(id, username, password, type, email, head_url);

        return user_p;
    }

    @Override
    public User SetAdmin(Integer id, String username, String password, Integer type, String email, String head_url) {
        Connection connection_u = JDBCTools.getConnection();
        String sql_u = "UPDATE user SET type = ? WHERE mid = ?";

        User user_s = null;
        PreparedStatement statement_u = null;

        try {
            statement_u = connection_u.prepareStatement(sql_u);

            statement_u.setInt(1,type);
            statement_u.setInt(2,id);


            statement_u.executeUpdate();
            if(statement_u!=null){
                System.out.println(username);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_u, statement_u,null);
        }
        user_s = new User(id, username, password, type, email, head_url);

        return user_s;
    }

    @Override
    public User Banuser(Integer id, String username, String password, Integer type, String email, String head_url) {
        Connection connection_u = JDBCTools.getConnection();
        String sql_u = "UPDATE user SET type = ? WHERE mid = ?";

        User user_s = null;
        PreparedStatement statement_u = null;

        try {
            statement_u = connection_u.prepareStatement(sql_u);

            statement_u.setInt(1,type);
            statement_u.setInt(2,id);


            statement_u.executeUpdate();
            if(statement_u!=null){
                System.out.println(username);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_u, statement_u,null);
        }
        user_s = new User(id, username, password, type, email, head_url);

        return user_s;
    }
}
