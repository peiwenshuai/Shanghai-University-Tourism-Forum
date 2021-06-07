package com.web6.service.impl;

import com.web6.entity.Pinlun;
import com.web6.repository.PinlunRepository;
import com.web6.repository.TieziRepository;
import com.web6.repository.impl.AddTieziRepositoryImpl;
import com.web6.repository.impl.PinlunRepositoryImpl;
import com.web6.service.AddpinglunService;

import java.sql.Date;

public class AddpinlunServiceImpl implements AddpinglunService {
    private PinlunRepository pinlunRepository=new PinlunRepositoryImpl();
    @Override
    public Pinlun Addpinlun(Integer pid, String pl, Date create_time,
                            Integer tzid, Integer plfs, Integer bplpid, String plname) {
        return pinlunRepository.Addpinlun(pid,  pl, create_time,  tzid,  plfs,  bplpid, plname);
    }
}
