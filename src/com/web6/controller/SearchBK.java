package com.web6.controller;

import com.web6.entity.tiezi;
import com.web6.repository.ListRepository;
import com.web6.repository.impl.ListRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchBK")
public class SearchBK extends HttpServlet {
    ListRepository listRepository=new ListRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer Bid = Integer.valueOf(req.getParameter("BID"));
        List<tiezi> lists=listRepository.find_Tz_BKId(Bid);
        System.out.println(req.getSession().getAttribute("pei"));
        List<tiezi> lists_2=null;
        if(!lists.isEmpty())
        {
            HttpSession Session = req.getSession();
            Session.setAttribute("lists", lists);
            resp.sendRedirect("/index.jsp");
        }else {

            HttpSession Session = req.getSession();
            String message="此板块无内容";
            Session.setAttribute("message_i", message);
            Session.setAttribute("lists", lists_2);

            resp.sendRedirect("/index.jsp");
        }
    }
}
