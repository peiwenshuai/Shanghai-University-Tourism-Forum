package com.web6.entity;

import java.sql.Date;

public class BK {
    private Integer Bid;
    private String Bname;

    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }
    public BK(Integer Bid, String Bname)
    {
       this.Bid=Bid;
       this.Bname=Bname;
    }
}
