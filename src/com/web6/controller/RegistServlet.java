package com.web6.controller;

import com.web6.entity.User;
import com.web6.service.FindUserService;
import com.web6.service.RegistService;
import com.web6.service.impl.FindUserServiceImpl;
import com.web6.service.impl.RegistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {

    RegistService registService=new RegistServiceImpl();
    FindUserService registServicefind=  new FindUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        String message=null;
        String url=null;
        String username_r=req.getParameter("username");
        System.out.println(username_r);
        username_r= new String(username_r.getBytes("ISO8859_1"), "UTF-8");
        String password_r1=(String)req.getParameter("password");
        String password_r2=(String)req.getParameter("password2");
        if(!password_r1.equals(password_r2))
        {
            message="两次密码不一致   "+password_r1+"  " +password_r2;
            url="htdl/regist.jsp";
            System.out.println(password_r1+"  " +password_r2);
            HttpSession Session = req.getSession();
            Session.setAttribute("message_r", message);
            req.getRequestDispatcher(url).forward(req,resp);
        }else {
            String email_r = req.getParameter("email");
            User userfind = registServicefind.FindUser(3, username_r, password_r1, 1, email_r, "/image/head.png");
            if (userfind != null) {
                message = "用户名已存在";
                url = "htdl/regist.jsp";

                HttpSession Session = req.getSession();
                Session.setAttribute("message_r", message);
                req.getRequestDispatcher(url).forward(req, resp);
            } else {
                User user = registService.regist(3, username_r, password_r1, 1, email_r, "/image/head.png");   // Service.login(0,username,password,0,"email","/head");

                if (user != null) {
                    HttpSession Session = req.getSession();
                    Session.setAttribute("user", user);
                    message = "注册成功，请登录";
                    Session.setAttribute("message_l", message);
                    url = "htdl/login.jsp";
                    //String contextPath=req.getContextPath();
                    //resp.sendRedirect("/htdl/login.jsp");
                    req.getRequestDispatcher(url).forward(req, resp);
                } else {
                    message = "注册失败请重新注册";
                    url = "htdl/regist.jsp";

                    HttpSession Session = req.getSession();
                    Session.setAttribute("message_r", message);
                    req.getRequestDispatcher(url).forward(req, resp);
                    //resp.sendRedirect("/htdl/regist.jsp");
                }
            }
        }
    }
}
