package com.web6.entity;

import java.sql.Date;

public class Pinlun {
    private Integer pid;
    private  String pl;

    private Date create_time;
   private String plname;
   private  Integer tzid;
   private Integer  plfs;
   private Integer  bplpid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getPlname() {
        return plname;
    }

    public void setPlname(String plname) {
        this.plname = plname;
    }

    public Integer getTzid() {
        return tzid;
    }

    public void setTzid(Integer tzid) {
        this.tzid = tzid;
    }

    public Integer getPlfs() {
        return plfs;
    }

    public void setPlfs(Integer plfs) {
        this.plfs = plfs;
    }

    public Integer getBplpid() {
        return bplpid;
    }

    public void setBplpid(Integer bplpid) {
        this.bplpid = bplpid;
    }
    public Pinlun(Integer pid,String pl,Date create_time,Integer tzid,Integer  plfs,Integer  bplpid,String plname){
        this.pid=pid;
        this.pl=pl;
        this.create_time=create_time;
        this.plname=plname;
        this.tzid=tzid;
        this.bplpid=bplpid;
        this.plfs=plfs;
    }
}
