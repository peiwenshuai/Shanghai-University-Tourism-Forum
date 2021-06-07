package com.web6.repository.impl;

import com.web6.entity.Gaozhi;
import com.web6.entity.tiezi;
import com.web6.repository.GaozhiRepository;
import com.web6.utils.JDBCTools;

import java.sql.*;


public class GaozhiRepositoryImpl  implements GaozhiRepository {
    @Override
    public Gaozhi findG(Integer Gid) {

        Connection connection = JDBCTools.getConnection();

        String sql = "SELECT * FROM tgao WHERE Gid = ? ORDER BY gcreate_time DESC";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       Gaozhi gaozhi=null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, Gid);


            resultSet = statement.executeQuery();

            if (resultSet.next()) {

                 gaozhi = new Gaozhi(resultSet.getInt(1), resultSet.getString(2)
                        , resultSet.getString(3), resultSet.getDate(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection, statement, resultSet);
        }

        return gaozhi;

    }

    @Override
    public Gaozhi removeG(Integer Gid) {
        Connection connection_r = JDBCTools.getConnection();


        String sql_a="DELETE FROM tgao WHERE Gid= ?";
        PreparedStatement statement_r = null;
        Gaozhi gaozhi=null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);
            statement_r.setInt (1,Gid);
            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(Gid);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }
        java.sql.Date time=  new java.sql.Date(System.currentTimeMillis());
        gaozhi = new Gaozhi(Gid,"title","neirong",time);
        return gaozhi;

    }

    @Override
    public Gaozhi addGao(Integer Gid, String title, String neirong, Date time) {
        Connection connection_r = JDBCTools.getConnection();
        String sql_a="INSERT INTO tgao(gtitle,neirong) VALUES(?,?)";
        PreparedStatement statement_r = null;
        Gaozhi gaozhi = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);
            statement_r.setString(1, title);
            statement_r.setString(2, neirong);
            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(title);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        gaozhi=new Gaozhi(Gid,title,neirong,time);
        return gaozhi;
    }
}
