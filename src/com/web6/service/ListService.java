package com.web6.service;

import com.web6.entity.Gaozhi;
import com.web6.entity.User;
import com.web6.entity.tiezi;

import java.util.List;

public interface ListService {
    public List<tiezi> findAll();
    public List<tiezi> findersou();
    public List<Gaozhi> findAllG();
    public List<tiezi> search(String title);
    public List<User> findU();
}
