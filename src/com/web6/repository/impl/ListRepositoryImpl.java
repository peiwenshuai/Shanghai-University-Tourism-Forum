package com.web6.repository.impl;

import com.web6.entity.*;

import com.web6.repository.ListRepository;
import com.web6.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public  class ListRepositoryImpl implements ListRepository {
    @Override
    public List<tiezi> findall() {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from tiezi ORDER BY tcreate_time DESC  ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<tiezi> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              tiezi  tieZi=new tiezi(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                                resultSet.getInt(6),resultSet.getInt(7),resultSet.getDate(8),
                                resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11));
              list.add(tieZi);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Pinlun> FindtPinlun(Integer tzid) {
        Connection connection= JDBCTools.getConnection();

        String sql="SELECT * FROM pinglun WHERE tzid = ? ORDER BY pcreate_time DESC ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        List<Pinlun> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,tzid);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                  Pinlun pinlun=new Pinlun(resultSet.getInt(1),resultSet.getString(2)
                          ,resultSet.getDate(3),resultSet.getInt(4),resultSet.getInt(5),
                          resultSet.getInt(6),resultSet.getString(7));
                list.add(pinlun);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<tiezi> findresou() {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from tiezi ORDER BY top DESC ,zan DESC";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<tiezi> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                tiezi  tieZi=new tiezi(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getInt(7),resultSet.getDate(8),
                        resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11));
                list.add(tieZi);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Gaozhi> findallG() {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from tgao ORDER BY gcreate_time DESC  ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Gaozhi> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Gaozhi gaozhi  =new Gaozhi(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
                list.add(gaozhi);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<tiezi> search(String title) {
        Connection connection= JDBCTools.getConnection();
String sql_s="SELECT * FROM tiezi WHERE title LIKE ? OR title LIKE ? OR title LIKE ? ORDER BY zan DESC , tcreate_time DESC ";

        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        List<tiezi> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql_s);
            preparedStatement.setString(1,title+"%");
            preparedStatement.setString(2,"%"+title);
            preparedStatement.setString(3,"%"+title+"%");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                tiezi  tieZi=new tiezi(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getInt(7),resultSet.getDate(8),
                        resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11));
                list.add(tieZi);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<User> findU() {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from user ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                User user=new User(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),
                        resultSet.getString(6));
                list.add(user);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;

    }

    @Override
    public List<String> findF(String Sname) {
        Connection connection= JDBCTools.getConnection();
        String sql_s="select Uf  from sixin where Us=?  GROUP BY Uf ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        List<String> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql_s);
            preparedStatement.setString(1,Sname);

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String Fname=resultSet.getString(1);

                list.add(Fname);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Sixin> findW(String Fname, String Sname) {

        Connection connection= JDBCTools.getConnection();
        String sql_s=" select * from sixin where (Us=? AND Uf=?) OR (Us=? AND Uf=?) ORDER BY screate_time";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        List<Sixin> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql_s);
            preparedStatement.setString(1,Sname);
            preparedStatement.setString(2,Fname);
            preparedStatement.setString(3,Fname);
            preparedStatement.setString(4,Sname);

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Sixin  sixin=new Sixin(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getDate(5),resultSet.getInt(6));
                list.add(sixin);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Integer findrecordS(String Fname, String Sname) {
        Connection connection= JDBCTools.getConnection();
        String sql_s="select COUNT(*) from sixin where Us=? AND Uf=? AND record=1 ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        Integer recordS=0;
        try {
            preparedStatement = connection.prepareStatement(sql_s);
            preparedStatement.setString(1,Sname);
            preparedStatement.setString(2,Fname);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                recordS=resultSet.getInt(1);


            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return recordS;
    }

    @Override
    public List<BK> findBKall() {
        Connection connection= JDBCTools.getConnection();

        String sql="select * from bk ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<BK> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                BK bk=new BK(resultSet.getInt(1),resultSet.getString(2));
                list.add(bk);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<tiezi> find_Tz_BKId(Integer bid) {
        Connection connection= JDBCTools.getConnection();

        String sql="SELECT * FROM tiezi WHERE bkid = ? ORDER BY tcreate_time DESC  ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        List<tiezi> list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bid);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                tiezi  tieZi=new tiezi(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getInt(7),resultSet.getDate(8),
                        resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11));
                list.add(tieZi);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.relaese(connection,preparedStatement,resultSet);
        }
        return list;
    }


}
