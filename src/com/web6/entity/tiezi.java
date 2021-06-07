package com.web6.entity;
import java.util.Date;


public class tiezi {
    private Integer tzid;
    private String title;
    private String zhengwen;
    private String tphoto;
    private Integer zan;
    private Integer liulan;
    private Integer top;
    private Integer Uid;
    private String name;
    private Integer bkid;
    private Date tcreate_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public Integer getTzid() {
        return tzid;
    }

    public void setTzid(Integer tzid) {
        this.tzid = tzid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZhengwen() {
        return zhengwen;
    }

    public void setZhengwen(String zhengwen) {
        this.zhengwen = zhengwen;
    }

    public String getTphoto() {
        return tphoto;
    }

    public void setTphoto(String tphoto) {
        this.tphoto = tphoto;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getLiulan() {
        return liulan;
    }

    public void setLiulan(Integer liulan) {
        this.liulan = liulan;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Date getTcreate_time() {
        return tcreate_time;
    }

    public void setTcreate_time(Date tcreate_time) {
        this.tcreate_time = tcreate_time;
    }
    public tiezi(Integer tzid, String title,String zhengwen,String tphoto,Integer zan, Integer liulan,
                 Integer top,Date tcreate_time,Integer Uid,Integer bkid ,String name){
        this.tzid=tzid;
        this.title=title;
        this.zhengwen=zhengwen;
        this.zan=zan;
        this.tphoto=tphoto;
        this.liulan=liulan;
        this.top=top;
        this.tcreate_time=tcreate_time;
        this.bkid=bkid;
        this.Uid=Uid;
        this.name=name;
    }

}
