package com.web6.repository.impl;

import com.web6.entity.BK;
import com.web6.entity.Gaozhi;
import com.web6.repository.BKRepository;
import com.web6.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BKRepositoryImpl implements BKRepository {
    @Override
    public BK AddB(String bname) {
        Connection connection_r = JDBCTools.getConnection();


        String sql_a="INSERT INTO bk(bkname) VALUES(?)";
        PreparedStatement statement_r = null;
        BK bk = null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);



            statement_r.setString(1, bname);


            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(bname);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        bk=new BK(1,bname);
        return bk;
    }

    @Override
    public BK RemoveB(Integer Bid) {
        Connection connection_r = JDBCTools.getConnection();


        String sql_a="DELETE FROM bk WHERE bkid= ?";
        PreparedStatement statement_r = null;
        BK bk=null;
        try {
            statement_r = connection_r.prepareStatement(sql_a);



            statement_r.setInt (1,Bid);



            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(Bid);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        bk = new BK(Bid,"title");
        return bk;

    }

    @Override
    public BK FindB(String bname) {
        Connection connection = JDBCTools.getConnection();

        String sql = "SELECT * FROM bk WHERE bkname=? ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        BK bk=null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, bname);


            resultSet = statement.executeQuery();

            if (resultSet.next()) {

                bk = new BK(resultSet.getInt(1), resultSet.getString(2));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection, statement, resultSet);
        }

        return bk;

    }
}
