package com.web6.repository;

import com.web6.entity.User;

public interface UserRepository {
    public User login(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public User regist(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public User FindUser(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public  User repassword(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public  User uploadimg(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public  User SetAdmin(Integer id, String username,String password,Integer type
            ,String email,String head_url);
    public  User Banuser(Integer id, String username,String password,Integer type
            ,String email,String head_url);
}
