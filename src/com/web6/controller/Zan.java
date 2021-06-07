package com.web6.controller;

import com.web6.entity.tiezi;
import com.web6.service.AdminService;
import com.web6.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/zan")
public class Zan extends HttpServlet {
    AdminService adminService=new AdminServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tzid = Integer.valueOf(req.getParameter("ID"));
        System.out.println("zan");
        Date tcreat_time = new Date(System.currentTimeMillis());
        tiezi TZ=null;
        adminService.ZANTZ(tzid,  "title",  "zhengwen",
                "tphoto",  0,  0, 0,tcreat_time,   0, 0,  "name");
        resp.sendRedirect("/htdl/tiezi.jsp?tzid="+tzid);
    }
}
