package com.web6.service.impl;

import com.web6.entity.Sixin;
import com.web6.repository.PinlunRepository;
import com.web6.repository.SixinRepository;
import com.web6.repository.impl.PinlunRepositoryImpl;
import com.web6.repository.impl.SixinRepositoryImpl;
import com.web6.service.AddSixinService;

import java.sql.Date;

public class AddSixinServiceImpl implements AddSixinService {
    private SixinRepository sixinRepository =new SixinRepositoryImpl();
    @Override
    public Sixin AddS(Integer sid, String ufname, String usname, String neirong, Date s_createtime, Integer record) {
        return sixinRepository.AddS(sid,ufname,usname,neirong,s_createtime,record);
    }
}
