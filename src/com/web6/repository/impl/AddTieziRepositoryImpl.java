package com.web6.repository.impl;

import com.web6.entity.User;
import com.web6.entity.tiezi;

import com.web6.repository.TieziRepository;
import com.web6.until.MD5Code;
import com.web6.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AddTieziRepositoryImpl implements TieziRepository {
    @Override
    public tiezi Addtiezi(Integer tzid, String title, String zhengwen, String tphoto,
                          Integer zan, Integer liulan, Integer top,Date tcreate_time,
                          Integer Uid, Integer bkid, String name) {
        Connection connection_r = JDBCTools.getConnection();

       System.out.println("jinru");
       String sql_a="INSERT INTO tiezi(title,zhengwen,tphoto,zan,liulan,top,Uid,bkid,name) VALUES(?,?,'/photo',0,0,0,?,?,?)";
        PreparedStatement statement_r = null;
        tiezi tiezi_a = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);

            System.out.println("shuju");
            statement_r.setString(1, title);
            statement_r.setString(2, zhengwen);
            statement_r.setInt (3,Uid);
            statement_r.setInt (4,bkid);
            statement_r.setString(5, name);


            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(title);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        tiezi_a=new  tiezi( tzid, title, zhengwen, tphoto, zan,  liulan,
                 top,tcreate_time,  Uid, bkid , name);
        return tiezi_a;
    }

    @Override
    public tiezi Findtiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from tiezi where tzid = ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        tiezi Tiezi=null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1,tzid);


            resultSet = statement.executeQuery();

            if(resultSet.next()){

                Tiezi=new tiezi( resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getInt(6),
                        resultSet.getInt(7),resultSet.getDate(8),
                        resultSet.getInt(9),resultSet.getInt(10),
                        resultSet.getString(11));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,statement,resultSet);
        }

        return Tiezi;
    }

    @Override
    public tiezi Liulantiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {

            Connection connection_r = JDBCTools.getConnection();

            System.out.println("liuru");
            String sql_a="INSERT INTO tiezi(title,zhengwen,tphoto,zan,liulan,top,Uid,bkid,name) VALUES(?,?,'/photo',0,0,0,?,1,?)";
            PreparedStatement statement_r = null;
            tiezi tiezi_a = null;
            try {
                statement_r = connection_r.prepareStatement(sql_a);

                System.out.println("shuju");
                statement_r.setString(1, title);
                statement_r.setString(2, zhengwen);
                statement_r.setInt (3,Uid);
                statement_r.setString(4, name);


                statement_r.executeUpdate();
                if(statement_r!=null){
                    System.out.println(title);

                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCTools.relaese(connection_r, statement_r,null);
            }

            tiezi_a=new  tiezi( tzid, title, zhengwen, tphoto, zan,  liulan,
                    top,tcreate_time,  Uid, bkid , name);
            return tiezi_a;
    }

    @Override
    public tiezi Toptiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        Connection connection_r = JDBCTools.getConnection();


        String sql_a="UPDATE tiezi SET top=? WHERE tzid=?";
        PreparedStatement statement_r = null;
        tiezi tiezi_a = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);

            System.out.println("推荐");
            statement_r.setInt(1,top);
            statement_r.setInt(2,tzid);

            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(title);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        tiezi_a=new  tiezi( tzid, title, zhengwen, tphoto, zan,  liulan,
                top,tcreate_time,  Uid, bkid , name);
        return tiezi_a;
    }

    @Override
    public tiezi RemoveTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        Connection connection_r = JDBCTools.getConnection();


        String sql_a="DELETE FROM tiezi WHERE tzid= ?";
        PreparedStatement statement_r = null;
        tiezi tiezi_a = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);

            System.out.println("shanchu");

            statement_r.setInt (1,tzid);



            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(title);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        tiezi_a=new  tiezi( tzid, title, zhengwen, tphoto, zan,  liulan,
                top,tcreate_time,  Uid, bkid , name);
        return tiezi_a;
    }

    @Override
    public tiezi ZANTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {

        Connection connection_r = JDBCTools.getConnection();


        String sql_a="UPDATE tiezi SET zan=zan+1 WHERE tzid=?";
        PreparedStatement statement_r = null;
        tiezi tiezi_a = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);

            System.out.println("zan");
            statement_r.setInt(1,tzid);


            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(title);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        tiezi_a=new  tiezi( tzid, title, zhengwen, tphoto, zan,  liulan,
                top,tcreate_time,  Uid, bkid , name);
        return tiezi_a;
    }
}
