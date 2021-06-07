package com.web6.controller;

import com.web6.entity.BK;
import com.web6.entity.Gaozhi;
import com.web6.repository.BKRepository;
import com.web6.repository.impl.BKRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AdminBK")
public class AdminBK extends HttpServlet {
    BKRepository bkRepository=new BKRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer Bid = Integer.valueOf(req.getParameter("ID"));
        BK bk=null;
        bk=bkRepository.RemoveB(Bid);
        if(bk!=null);
        resp.sendRedirect("/Admin/AdminBK.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bname = (String) req.getParameter("bname");
        System.out.println(bname);
        bname=new String(bname.getBytes("ISO8859_1"), "UTF-8");
        BK bk=bkRepository.AddB(bname);

        if(bk!=null)
        {
            resp.sendRedirect("/Admin/AdminBK.jsp");
        }
    }
}
