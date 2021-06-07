package com.web6.controller;

import com.web6.entity.User;
import com.web6.entity.tiezi;
import com.web6.repository.BKRepository;
import com.web6.repository.impl.BKRepositoryImpl;
import com.web6.service.AddtieziService;
import com.web6.service.FindUserService;
import com.web6.service.impl.AddtieziServiceImpl;
import com.web6.service.impl.FindUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/addtiezi")
public class AddtieziServlet extends HttpServlet {

    AddtieziService addtieziService=new AddtieziServiceImpl();
    FindUserService findUserService =  new FindUserServiceImpl();
    BKRepository bkRepository=new BKRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;
        String url = null;
        String username_a = (String) req.getParameter("namem");
        username_a = new String(username_a.getBytes("ISO8859_1"), "UTF-8");
        String bname=(String) req.getParameter("bk");
        bname=new String(bname.getBytes("ISO8859_1"), "UTF-8");
        System.out.println(bname);
        Integer bkid=bkRepository.FindB(bname).getBid();
        System.out.println(bkid);
        String zhengwen = (String) req.getParameter("zhengwen");

        zhengwen = new String(zhengwen.getBytes("ISO8859_1"), "UTF-8");
        Integer uid = Integer.valueOf(req.getParameter("uid"));
        String title = req.getParameter("title");

        title = new String(title.getBytes("ISO8859_1"), "UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (title.equals("")) {
            HttpSession Session = req.getSession();
            String message_zw = "标题不能为空";

            Session.setAttribute("message_zw", message_zw);
            Session.setAttribute("namem", username_a);
            Session.setAttribute("uid", uid);
            url = "add_t.jsp?namem=" + username_a+"&uid="+uid;;
            url=new String(url.getBytes("UTF-8"),"ISO8859_1");
            resp.sendRedirect(url);
        } else if (zhengwen.equals("")) {
            HttpSession Session = req.getSession();
            String message_zw = "正文不能为空";

            Session.setAttribute("message_zw", message_zw);
            url=new String(url.getBytes("UTF-8"),"ISO8859_1");

            url = "add_t.jsp?namem=" + username_a+"&uid="+uid;;

            resp.sendRedirect(url);
        } else {
            Date tcreat_time = new Date(System.currentTimeMillis());


            tiezi Tiezi = addtieziService.Addtiezi(3, title, zhengwen, "/head", 0, 0, 0, tcreat_time, uid, bkid, username_a);

            if (Tiezi != null) {
                HttpSession Session = req.getSession();
                User userfind = findUserService.FindUser(3, username_a, "12", 1, "email_r", "/image/head.png");
                Session.setAttribute("user", userfind);
                Session.setAttribute("Tiezi", Tiezi);
                message = "添加成功";
                Session.setAttribute("message_a", message);

                url = "index.jsp";
                resp.sendRedirect(url);

            } else {
                message = "添加失败";
                url = "add_t.jsp?namem=" + username_a+"&uid="+uid;

                url=new String(url.getBytes("UTF-8"),"ISO8859_1");
                HttpSession Session = req.getSession();

                Session.setAttribute("message_as", message);
                resp.sendRedirect(url);
            }


        }
    }

}

