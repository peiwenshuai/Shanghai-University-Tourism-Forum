package com.web6.service.impl;

import com.web6.entity.Gaozhi;
import com.web6.entity.User;
import com.web6.entity.tiezi;

import com.web6.repository.ListRepository;

import com.web6.repository.impl.ListRepositoryImpl;
import com.web6.service.ListService;

import java.util.List;

public class ListServiceImpl implements ListService {
    private ListRepository listRepository=new ListRepositoryImpl();
    @Override
    public List<tiezi> findAll() {
        return listRepository.findall();
    }

    @Override
    public List<tiezi> findersou() {
        return listRepository.findresou();
    }

    @Override
    public List<Gaozhi> findAllG() {
        return listRepository.findallG();
    }

    @Override
    public List<tiezi> search(String title) { return listRepository.search(title); }

    @Override
    public List<User> findU() { return listRepository.findU(); }
}
