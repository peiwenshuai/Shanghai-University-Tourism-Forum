package com.web6.service;

import com.web6.entity.User;

public interface RepasswordService {
    public User repassword(Integer id , String username, String password
            , Integer type, String email, String head_url);
}
