package com.web6.controller;

import com.web6.entity.User;
import com.web6.entity.tiezi;
import com.web6.service.ListService;
import com.web6.service.impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    public ListService listService=new ListServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String title=req.getParameter("search");
        title=new String(title.getBytes("ISO8859_1"), "UTF-8");


        List<tiezi> lists=listService.search(title);
        List<tiezi> lists_2=null;
        if(!lists.isEmpty())
        {
            HttpSession Session = req.getSession();
            Session.setAttribute("lists", lists);
           // Session.setAttribute("user", req.getSession().getAttribute("user"));
            resp.sendRedirect("/index.jsp");
        }else {

            HttpSession Session = req.getSession();
            String message="没有找到你要的结果";
            Session.setAttribute("message_i", message);
            Session.setAttribute("lists", lists_2);
           //Session.setAttribute("user", req.getSession().getAttribute("user"));
            resp.sendRedirect("/index.jsp");
        }
    }
}
