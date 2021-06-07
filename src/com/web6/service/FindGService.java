package com.web6.service;

import com.web6.entity.Gaozhi;

import java.sql.Date;
import java.util.List;

public interface FindGService {
    public Gaozhi FindGService(Integer Gid);
    public Gaozhi RemoveGService(Integer Gid);
    public Gaozhi addGao(Integer Gid,String title, String neirong, Date time);
}
