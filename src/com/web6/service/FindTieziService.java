package com.web6.service;

import com.web6.entity.tiezi;

import java.util.Date;

public interface FindTieziService {
    public tiezi Findtiezi(Integer tzid, String title, String zhengwen, String tphoto, Integer zan, Integer liulan,
                          Integer top, Date tcreate_time, Integer Uid, Integer bkid , String name);
}
