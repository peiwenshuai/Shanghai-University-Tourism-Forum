package com.web6.repository;

import com.web6.entity.Pinlun;

import java.sql.Date;

public interface PinlunRepository {
    public Pinlun Addpinlun(Integer pid, String pl, Date create_time, Integer tzid, Integer  plfs, Integer  bplpid,
                            String plname);
}
