package com.web6.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer  type;
    private String header_url;
    private Date create_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHeader_url() {
        return header_url;
    }

    public void setHeader_url(String header_url) {
        this.header_url = header_url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public User(Integer id, String username, String password,Integer type,String email,String header_url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email=email;
        this.header_url=header_url;
        this.type=type;

    }
}