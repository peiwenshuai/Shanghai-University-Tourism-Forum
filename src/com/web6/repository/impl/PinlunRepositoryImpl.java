package com.web6.repository.impl;

import com.web6.entity.Pinlun;
import com.web6.entity.User;

import com.web6.repository.PinlunRepository;
import com.web6.until.MD5Code;
import com.web6.utils.JDBCTools;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PinlunRepositoryImpl implements PinlunRepository {
    @Override
    public Pinlun Addpinlun(Integer pid, String pl, Date create_time, Integer tzid, Integer plfs, Integer bplpid,String plname) {
        Connection connection_r = JDBCTools.getConnection();

        String sql_r = "INSERT INTO pinglun(pl,tzid,plfs,bplrid,Uname) VALUES(?,?,0,0,?)";

        PreparedStatement statement_r = null;
        Pinlun pinlun = null;
        try {
            statement_r = connection_r.prepareStatement(sql_r);


            statement_r.setString(1, pl);
            statement_r.setInt(2, tzid);
            statement_r.setString(3, plname);


            statement_r.executeUpdate();
            if(statement_r!=null){
                System.out.println(pl);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.relaese(connection_r, statement_r,null);
        }

        pinlun=new Pinlun(pid, pl,  create_time,
                  tzid,  plfs, bplpid, plname);
        return pinlun;
    }
}
