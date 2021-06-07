package com.web6.repository;

import com.web6.entity.BK;

public interface BKRepository {
    public BK AddB(String bname);
    public BK RemoveB( Integer Bid);
    public BK FindB(String bname);
}
