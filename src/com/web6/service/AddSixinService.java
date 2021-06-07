package com.web6.service;

import com.web6.entity.Sixin;

import java.sql.Date;

public interface AddSixinService {
    public Sixin AddS(Integer sid, String ufname, String usname, String neirong, Date s_createtime, Integer record);

}
