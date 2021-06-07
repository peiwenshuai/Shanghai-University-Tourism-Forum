package com.web6.service;

import com.web6.entity.User;

public interface RegistService {
    public User regist(Integer id , String username, String password
            , Integer type, String email, String head_url);
}
