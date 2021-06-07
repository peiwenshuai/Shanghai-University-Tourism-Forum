package com.web6.service.impl;

import com.web6.entity.Pinlun;
import com.web6.repository.ListRepository;
import com.web6.repository.impl.ListRepositoryImpl;
import com.web6.service.ListPinlunTService;


import java.util.List;

public class FindTpinlunServiceImpl implements ListPinlunTService {
   private ListRepository listRepository=new ListRepositoryImpl();

    @Override
    public List<Pinlun> FindTpinlun(Integer tzid) {

        return listRepository.FindtPinlun(tzid) ;
    }
}
