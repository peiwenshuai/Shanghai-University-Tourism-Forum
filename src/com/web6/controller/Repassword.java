package com.web6.controller;

import com.web6.entity.User;
import com.web6.service.LoginService;
import com.web6.service.RepasswordService;
import com.web6.service.impl.LoginServiceImpl;
import com.web6.service.impl.RepasswordServiceImpl;
import com.web6.until.MD5Code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/repassword")
public class Repassword extends HttpServlet {
    public LoginService loginService=new LoginServiceImpl();
    public RepasswordService repasswordService=new RepasswordServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             String password1=req.getParameter("password");
             password1=new MD5Code().getMD5ofStr(password1);
             String password2=req.getParameter("password2");
             String name=req.getParameter("rpname");
             System.out.println(password2);
             name=new String(name.getBytes("ISO8859_1"), "UTF-8");
             System.out.println(name);
             User user =loginService.login(0,name,password1,0,"email","/head");
             if(user!=null){
                 User userrp=repasswordService.repassword(0,name,password2,0,"email","/head");
                 if(userrp!=null) {
                     resp.sendRedirect("htdl/login.jsp");
                 }else {
                     System.out.println("?");
                 }
             }else{
                 resp.sendRedirect("/index.jsp");
             }
    }
}
