package com.web6.service.impl;

import com.web6.entity.User;
import com.web6.entity.tiezi;
import com.web6.repository.TieziRepository;
import com.web6.repository.UserRepository;
import com.web6.repository.impl.AddTieziRepositoryImpl;
import com.web6.repository.impl.UserRepositoryImpl;
import com.web6.service.AdminService;

import java.util.Date;

public class AdminServiceImpl implements AdminService {
    private UserRepository userRepository=new UserRepositoryImpl();
    private TieziRepository tieziRepository=new AddTieziRepositoryImpl();
    @Override
    public User SetAdmin(Integer id, String username, String password, Integer type, String email, String head_url) {
        return userRepository.SetAdmin(id, username, password, type, email, head_url);
    }

    @Override
    public User BanAdmin(Integer id, String username, String password, Integer type, String email, String head_url) {
        return userRepository.Banuser(id, username, password, type, email, head_url);
    }

    @Override
    public tiezi topTiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        return tieziRepository.Toptiezi(tzid,  title,  zhengwen,
                tphoto,  zan,  liulan, top,tcreate_time,   Uid, bkid,  name);
    }

    @Override
    public tiezi RemoveTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        return tieziRepository.RemoveTZ(tzid,  title,  zhengwen,
                tphoto,  zan,  liulan, top,tcreate_time,   Uid, bkid,  name);
    }

    @Override
    public tiezi ZANTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan, Integer top, Date tcreate_time, Integer Uid, Integer bkid, String name) {
        return tieziRepository.ZANTZ(tzid,  title,  zhengwen,
                tphoto,  zan,  liulan, top,tcreate_time,   Uid, bkid,  name);
    }
}
