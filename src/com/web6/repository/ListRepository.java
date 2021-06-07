package com.web6.repository;

import com.web6.entity.*;

import java.util.List;

public interface ListRepository {
    public List<tiezi> findall();
    public List<Pinlun> FindtPinlun(Integer tzid);
    public List<tiezi> findresou();
    public List<Gaozhi> findallG();
    public List<tiezi> search(String title);
    public List<User> findU();
    public List<String> findF(String Sname);
    public List<Sixin> findW(String Fname,String Sname);
    public Integer findrecordS(String Fname,String Sname);
    public List<BK> findBKall();
    public List<tiezi> find_Tz_BKId(Integer bid);

}
