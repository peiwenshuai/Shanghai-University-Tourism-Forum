package com.web6.entity;

import java.sql.Date;

public class Sixin {
    private Integer Sid;
    private String Ufname;
    private String Usname;
    private String neirong;
    private Date s_createtime;
    private Integer record;

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public String getUfname() {
        return Ufname;
    }

    public void setUfname(String ufname) {
        Ufname = ufname;
    }

    public String getUsname() {
        return Usname;
    }

    public void setUsname(String usname) {
        Usname = usname;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public Date getS_createtime() {
        return s_createtime;
    }

    public void setS_createtime(Date s_createtime) {
        this.s_createtime = s_createtime;
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }
    public Sixin(Integer sid,String ufname,String usname,String neirong, Date s_createtime,Integer record)
    {
        this.Sid=sid;
        this.Ufname=ufname;
        this.Usname=usname;
        this.neirong=neirong;
        this.s_createtime=s_createtime;
        this.record=record;
    }
}
