<%@ page import="java.util.List" %>
<%@ page import="com.web6.entity.Gaozhi" %>
<%@ page import="com.web6.entity.Pinlun" %>
<%@ page import="com.web6.entity.tiezi" %>
<%@ page import="com.web6.repository.TieziRepository" %>
<%@ page import="com.web6.repository.impl.AddTieziRepositoryImpl" %>
<%@ page import="com.web6.repository.GaozhiRepository" %>
<%@ page import="com.web6.repository.impl.GaozhiRepositoryImpl" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/4/13
  Time: 12:26 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page   pageEncoding="utf-8"%>

<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%!

    Gaozhi findg(Integer Gid) {
        GaozhiRepository gaozhiRepository = new GaozhiRepositoryImpl();

        Gaozhi gaozhi = gaozhiRepository.findG(Gid);
        return gaozhi;
    }
%>

<html lang="zh" class="no-js">
<head>
    <base href="<%=basePath%>"/>
    <title>通知</title>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->
</head>
<body>
<%
    Integer Gid=Integer.valueOf(request.getParameter("Gid")).intValue();
    System.out.println(Gid);
    Gaozhi gaozhi=findg(Gid);

%>
<div class="bg-back">
    <ul class="shadows">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
    <ul class="drive">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
 <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container" style="z-index: 10000;
    position: absolute;
    top: 100px;
    bottom: 20px;
    left:calc(20%);
    right: calc(20%);
    overflow-y: scroll;
    background-color: white;
		">
        <ul class="cd-switcher" >
            <li></li>
            <li><a  class="selected"><%=gaozhi.getGtitle()%></a></li>
            <li></li>
        </ul>
        <br/>
        <br/>
        <br/>
        <li></li>
        <li></li>


        </p>
        <p  style="text-indent:6em;">

        <%=gaozhi.getNeirong()%>
        <br/>
    </p>
        <p style="text-indent:30em;">
            <%=gaozhi.getGcrteate_time()%>
        </p>




            <a style="
                          display: inline-block;
                          position: absolute;
                          right: 90px;
                          cursor:pointer;
                          bottom: -22px;
                          font-size: 14px;
                          color: #3277fc;" href="index.jsp">首页</a>

        </p>



    </div> <!-- cd-user-modal -->






<!-- cd-user-modal -->
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>


