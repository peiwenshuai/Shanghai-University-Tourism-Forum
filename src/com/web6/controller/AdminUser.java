package com.web6.controller;

import com.web6.entity.User;
import com.web6.service.AdminService;
import com.web6.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet {

    AdminService adminUser=new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("ID"));
        Integer type = Integer.valueOf(req.getParameter("type"));
        switch (type) {
            case 0:
                User user = adminUser.SetAdmin(id, "username", "password", 0, "email", "head_url");
                if (user != null) {
                    resp.sendRedirect("/Admin/AdminUser.jsp");
                }
                break;
            case 1:
                User userj = adminUser.SetAdmin(id, "username", "password", 1, "email", "head_url");
                if (userj != null) {
                    resp.sendRedirect("/Admin/AdminUser.jsp");
                }
                break;
            case 2:
                User userb = adminUser.BanAdmin(id, "username", "password", 2, "email", "head_url");
                if (userb != null) {
                    resp.sendRedirect("/Admin/AdminUser.jsp");
                }


        }
    }

}
