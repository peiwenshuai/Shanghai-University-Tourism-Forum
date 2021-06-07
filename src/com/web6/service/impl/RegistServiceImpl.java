package com.web6.service.impl;

import com.web6.entity.User;
import com.web6.repository.UserRepository;
import com.web6.repository.impl.UserRepositoryImpl;
import com.web6.service.RegistService;

public class RegistServiceImpl implements RegistService {
    private UserRepository userRepository=new UserRepositoryImpl();

    @Override
    public User regist(Integer id, String username, String password
            , Integer type, String email, String head_url) {
        return userRepository.regist( id, username
                ,  password,  type,  email, head_url);
    }
}
