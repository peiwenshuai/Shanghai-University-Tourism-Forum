package com.web6.service;

import com.web6.entity.User;

public interface UploadimgService {
    public User Uploadimg(Integer id , String username, String password
            , Integer type, String email, String head_url);
}
