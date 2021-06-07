package com.web6.repository;

import com.web6.entity.Sixin;

import java.sql.Date;

public interface SixinRepository {
  public Sixin AddS(Integer sid, String ufname, String usname,String neirong, Date s_createtime, Integer record);
  public Sixin RecordS( String Fname, String Sname);
}
