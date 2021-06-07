package com.web6.controller;

import com.alibaba.fastjson.JSONObject;
import com.web6.service.AddSixinService;
import com.web6.service.impl.AddSixinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/Sixin")
public class Sixin extends HttpServlet {
    AddSixinService addSixinService=new AddSixinServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username_s = (String) req.getParameter("user");
        username_s = new String(username_s.getBytes("ISO8859_1"), "UTF-8");

        String ftname_s = (String)req.getParameter("ftname");
        ftname_s = new String(ftname_s.getBytes("ISO8859_1"), "UTF-8");
        System.out.println("收信人 "+ftname_s);

       // Integer tzid = Integer.valueOf(req.getParameter("tzid"));
        Date S_crteate=new Date(System.currentTimeMillis());

        String neirong=(String)req.getParameter("neirong");
        neirong = new String(neirong.getBytes("ISO8859_1"), "UTF-8");
        if(neirong.equals(""))
        {

            String url="/htdl/sixin.jsp?ftname="+ftname_s+"&user="+username_s;
            url=new String(url.getBytes("UTF-8"),"ISO8859_1");
            resp.sendRedirect(url);

        }
        else
        {
            com.web6.entity.Sixin sixin=addSixinService.AddS(1,username_s,ftname_s,neirong,S_crteate,1);
            if(sixin!=null)
            {
                String url="/htdl/sixin.jsp?ftname="+ftname_s+"&user="+username_s;
                url=new String(url.getBytes("UTF-8"),"ISO8859_1");
                resp.sendRedirect(url);
            }
        }

    }
}
