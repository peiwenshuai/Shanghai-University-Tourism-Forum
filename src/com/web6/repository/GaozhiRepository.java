package com.web6.repository;

import com.web6.entity.Gaozhi;

import java.sql.Date;

public interface GaozhiRepository {
    public Gaozhi findG(Integer Gid);
    public Gaozhi removeG(Integer Gid);
    public Gaozhi addGao(Integer Gid,String title, String neirong, Date time);
}
