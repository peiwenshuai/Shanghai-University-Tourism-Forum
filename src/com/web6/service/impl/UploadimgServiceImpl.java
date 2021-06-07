package com.web6.service.impl;

import com.web6.entity.User;
import com.web6.repository.UserRepository;
import com.web6.repository.impl.UserRepositoryImpl;
import com.web6.service.UploadimgService;

public class UploadimgServiceImpl implements UploadimgService {
    private UserRepository userRepository=new UserRepositoryImpl();
    @Override
    public User Uploadimg(Integer id, String username, String password, Integer type, String email, String head_url) {
        return userRepository.uploadimg(id, username,  password,  type, email,  head_url);
    }
}
