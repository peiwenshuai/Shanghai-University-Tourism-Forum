package com.web6.controller;
import com.web6.entity.User;
import com.web6.entity.tiezi;
import com.web6.service.FindUserService;
import com.web6.service.ListService;
import com.web6.service.LoginService;
import com.web6.service.impl.FindUserServiceImpl;
import com.web6.service.impl.ListServiceImpl;
import com.web6.service.impl.LoginServiceImpl;
import com.web6.until.MD5Code;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
  */
    public LoginService loginService=new LoginServiceImpl();
    public ListService listService=new ListServiceImpl();
    public FindUserService registServicefindL=  new FindUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        List<tiezi> list=listService.findAll();
        String username=req.getParameter("username");
        username= new String(username.getBytes("ISO8859_1"), "UTF-8");
        String password=req.getParameter("password");
        password=new MD5Code().getMD5ofStr(password);
        User  user =loginService.login(0,username,password,0,"email","/head");
        System.out.println(username+password);
        String message=null;
        String url=null;
        User userfindL= registServicefindL.FindUser(3,username,password,1,"email","/image/head.png");
        if(userfindL==null)
        {
            message="用户名不存在，请注册";
            url="htdl/regist.jsp";

            HttpSession Session = req.getSession();
            Session.setAttribute("message_r", message);
            req.getRequestDispatcher(url).forward(req,resp);
        }else {
            if (user != null) {
                HttpSession Session = req.getSession();
                switch (user.getType())
                {
                    case 0:
                        resp.sendRedirect("/Admin/AdminUser.jsp");
                        break;
                    case 2:
                        message = "您被禁止登录";

                        Session.setAttribute("message_l", message);
                        resp.sendRedirect("/htdl/login.jsp");
                        break;
                    case 1:


                        Session.setAttribute("user", user);
                        Session.setAttribute("list", list);


                        message = "登录成功";
                        Session.setAttribute("message_i", message);
                        resp.sendRedirect("/index.jsp");
                        break;
                }

            } else {
                message = "密码错误";


                HttpSession Session = req.getSession();
                Session.setAttribute("message_l", message);
                resp.sendRedirect("/htdl/login.jsp");
            }
        }
    }
}

