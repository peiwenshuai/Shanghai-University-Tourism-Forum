package com.web6.controller;

import com.web6.entity.tiezi;
import com.web6.repository.TieziRepository;
import com.web6.service.AddtieziService;
import com.web6.service.AdminService;
import com.web6.service.impl.AddtieziServiceImpl;
import com.web6.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AdminTieZi")
public class AdminTiezi extends HttpServlet {
   AdminService adminService=new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tzid = Integer.valueOf(req.getParameter("ID"));
        Integer type = Integer.valueOf(req.getParameter("type"));
        Date tcreat_time = new Date(System.currentTimeMillis());
        tiezi TZ=null;
        switch (type){
            case 0:
               TZ=adminService.topTiezi(tzid,  "title",  "zhengwen",
                        "tphoto",  0,  0, 0,tcreat_time,   0, 0,  "name");
                break;
            case 1:
                TZ=adminService.topTiezi(tzid,  "title",  "zhengwen",
                        "tphoto",  0,  0, 1,tcreat_time,   0, 0,  "name");
                break;
            case 2:
                TZ=adminService.RemoveTZ(tzid,  "title",  "zhengwen",
                        "tphoto",  0,  0, 0,tcreat_time,   0, 0,  "name");
                break;

        }
        if ( TZ!= null) {
            resp.sendRedirect("/Admin/AdminTiezi.jsp");
        }
    }
}
