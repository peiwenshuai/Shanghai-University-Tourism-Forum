package com.web6.service.impl;

import com.web6.entity.tiezi;
import com.web6.repository.TieziRepository;
import com.web6.repository.impl.AddTieziRepositoryImpl;
import com.web6.service.AddtieziService;

import java.util.Date;

public class AddtieziServiceImpl implements AddtieziService {
    private TieziRepository addTieziRepository=new AddTieziRepositoryImpl();
    @Override
    public tiezi Addtiezi(Integer tzid, String title, String zhengwen,
                          String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time,
                           Integer Uid, Integer bkid, String name) {
        return addTieziRepository.Addtiezi( tzid,  title,  zhengwen,
                tphoto,  zan,  liulan, top,tcreate_time,   Uid, bkid,  name);
    }
}
