package com.web6.entity;

import java.sql.Date;

public class Gaozhi {
    private Integer gid;
    private String gtitle;
    private String neirong;
    private Date gcrteate_time;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public Date getGcrteate_time() {
        return gcrteate_time;
    }

    public void setGcrteate_time(Date gcrteate_time) {
        this.gcrteate_time = gcrteate_time;
    }
    public Gaozhi(Integer gid,String gtitle,String neirong,Date gcrteate_time){
        this.gid=gid;
        this.gtitle=gtitle;
        this.neirong=neirong;
        this.gcrteate_time=gcrteate_time;
    }
}
