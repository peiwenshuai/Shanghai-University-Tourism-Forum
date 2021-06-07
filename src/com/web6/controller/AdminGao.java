package com.web6.controller;

import com.web6.entity.Gaozhi;
import com.web6.service.FindGService;
import com.web6.service.impl.FindGServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AdminGao")
public class AdminGao extends HttpServlet {
    FindGService findGService=new FindGServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer Gid = Integer.valueOf(req.getParameter("ID"));
        Gaozhi gaozhi=null;
        gaozhi=findGService.RemoveGService(Gid);
        if(gaozhi!=null);
        resp.sendRedirect("/Admin/AdminGZ.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gtitle = (String) req.getParameter("gtitle");
        gtitle=new String(gtitle.getBytes("ISO8859_1"), "UTF-8");
        String neirong = (String) req.getParameter("gonggao");
        neirong=new String(neirong.getBytes("ISO8859_1"), "UTF-8");
        Date time=new Date(System.currentTimeMillis());
        Gaozhi gaozhi_a=findGService.addGao(1,gtitle,neirong,time);
        if(gaozhi_a!=null)
        {
            resp.sendRedirect("/Admin/AdminGZ.jsp");
        }
    }
}
