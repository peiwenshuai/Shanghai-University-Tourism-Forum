package com.web6.service.impl;

import com.web6.entity.Gaozhi;
import com.web6.repository.GaozhiRepository;
import com.web6.repository.impl.GaozhiRepositoryImpl;
import com.web6.service.FindGService;

import java.sql.Date;
import java.util.List;

public class FindGServiceImpl implements FindGService {
    private GaozhiRepository gaozhiRepository=new GaozhiRepositoryImpl();
    @Override
    public Gaozhi FindGService(Integer Gid) {
        return gaozhiRepository.findG(Gid);
    }

    @Override
    public Gaozhi RemoveGService(Integer Gid) {
        return gaozhiRepository.removeG(Gid);
    }

    @Override
    public Gaozhi addGao(Integer Gid, String title, String neirong, Date time) {
        return gaozhiRepository.addGao( Gid,title, neirong, time);
    }
}
