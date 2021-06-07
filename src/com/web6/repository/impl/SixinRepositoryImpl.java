package com.web6.repository.impl;

import com.web6.entity.Pinlun;
import com.web6.entity.Sixin;
import com.web6.entity.tiezi;
import com.web6.repository.SixinRepository;
import com.web6.utils.JDBCTools;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SixinRepositoryImpl implements SixinRepository {
    @Override
    public Sixin AddS(Integer sid, String ufname, String usname,String neirong, Date s_createtime, Integer record) {
        Connection connection_r = JDBCTools.getConnection();

        String sql_r = "INSERT INTO sixin(Uf,Us,neirong,record) VALUES(?,?,?,1)";

        PreparedStatement statement_r = null;
        Sixin sixin = null;
        try {
            statement_r = connection_r.prepareStatement(sql_r);


            statement_r.setString(1, ufname);
            statement_r.setString(2, usname);
            statement_r.setString(3, neirong);


            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(sixin);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        sixin=new Sixin(sid,ufname,usname,neirong,s_createtime,record);
        return sixin;
    }

    @Override
    public Sixin RecordS(String Fname, String Sname) {

            Connection connection_r = JDBCTools.getConnection();


            String sql_a="UPDATE sixin SET record=0 WHERE Uf=? and Us=?";
            PreparedStatement statement_r = null;
            Sixin sixin= null;
            try {
                statement_r = connection_r.prepareStatement(sql_a);
                statement_r.setString(1,Fname);
                statement_r.setString(2,Sname);


                statement_r.executeUpdate();



            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCTools.relaese(connection_r, statement_r,null);
            }
            Date time=new Date(System.currentTimeMillis());

            sixin=new Sixin(0,Fname,Sname,"neirong",time,0);
            return sixin;
    }
}
