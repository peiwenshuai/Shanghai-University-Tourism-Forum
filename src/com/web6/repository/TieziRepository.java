package com.web6.repository;

import com.web6.entity.tiezi;

import java.util.Date;

public interface TieziRepository {
    public tiezi Addtiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi Findtiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi Liulantiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                           Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi Toptiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi RemoveTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
    public tiezi ZANTZ(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
}

