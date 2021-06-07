package com.web6.controller;

import com.web6.entity.Pinlun;
import com.web6.service.AddpinglunService;
import com.web6.service.impl.AddpinlunServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/pinlun")
public class Addpinlun extends HttpServlet {
    AddpinglunService addpinglunService=new AddpinlunServiceImpl();
    String message=null;
    String url=null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username_a = (String) req.getParameter("namem");
        username_a = new String(username_a.getBytes("ISO8859_1"), "UTF-8");
        System.out.println("shd "+username_a.length());
        Integer tzid = Integer.valueOf(req.getParameter("tzid"));
        String pinlun = (String) req.getParameter("pinlun");
        pinlun = new String(pinlun.getBytes("ISO8859_1"), "UTF-8");

       if(username_a == null || username_a.length() <= 0||"".equals(username_a)||username_a.equals("null")) {
            HttpSession Session = req.getSession();
            String message_pl = "请登录";

            Session.setAttribute("message_pl", message_pl);
            url = "htdl/login.jsp";

            req.getRequestDispatcher(url).forward(req, resp);
        }
       else{

            Date tcreat_time = new Date(System.currentTimeMillis());
            System.out.println(tzid);
            System.out.println(pinlun);
            Pinlun pinlun1 = addpinglunService.Addpinlun(0, pinlun, tcreat_time, tzid, 0, 0, username_a);
            if (pinlun1 != null) {
                HttpSession Session = req.getSession();
                Session.setAttribute("Pinlun", pinlun1);
                message = "添加成功";
                Session.setAttribute("message_pl", message);

                 String url="/htdl/tiezi.jsp?tzid="+tzid+"&username="+username_a;
                url=new String(url.getBytes("UTF-8"),"ISO8859_1");


                resp.sendRedirect(url);
            } else {
                message = "添加失败";


                HttpSession Session = req.getSession();
                Session.setAttribute("message_pl", message);
                resp.sendRedirect(url);

            }


        }
    }
}
