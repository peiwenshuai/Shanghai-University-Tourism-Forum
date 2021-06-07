package com.web6.service;

import com.web6.entity.User;
import com.web6.entity.tiezi;

import java.util.Date;

public interface AdminService {
    public User SetAdmin(Integer id , String username, String password
            , Integer type, String email, String head_url);
    public User BanAdmin(Integer id , String username, String password
            , Integer type, String email, String head_url);
    public tiezi topTiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi RemoveTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi ZANTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
}
