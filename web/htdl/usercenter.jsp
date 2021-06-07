<%@ page import="com.web6.entity.User" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/3/27
  Time: 9:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page   pageEncoding="utf-8"%>

<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<html lang="zh" class="no-js">
<head>
    <base href="<%=basePath%>"/>
    <title>用户中心</title>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->
</head>
<body>
<%
    String ftname=request.getParameter("usercentername");
    String user=request.getParameter("username");



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
<div style="z-index: 10000;
    position: absolute;

    top:0px;
    height: 100%;
    left:calc(20%);
    right: calc(20%);
    overflow-y: scroll;
    background-color: white;
		"  class="cd-user-modal is-visible"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container" style="height: 100%">
        <ul class="cd-switcher">
            <li><a  class="selected">个人中心</a></li>

        </ul>
        <div style="position:absolute;left: 80px">
        <p class="fieldset">
            昵称：<% out.println(ftname);%>

        </p>
        <p class="fieldset">
            头像：
            <br/>
            <br/>
            <%out.println(" <img  style=\"border-radius: 25px;width: 100px;height: 100px\" width= 50px src=\"upload/"+ftname+
            ".png\" onerror=\"javascript:this.src='upload/cd-icon-username.png';\">");%>

        </p>

    <%


        if(ftname.equals(user)==false)
        out.println("<!--");
    //enctye="multipart/form-data"
    %>

        <form  method="post" action="/uploadphoto?tname=<%=ftname%>" enctype="multipart/form-data">


            <input type="file" name="img">
            <input type="submit" value="提交">
        </form>
            <form class="cd-form " action="/repassword" method="post">

                       <input type="hidden" name="rpname" value="<%=ftname%>">
                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">旧密码</label>
                    <input class="full-width has-padding has-border" name="password" id="signup-password" type="password"  placeholder="请输入密码">
                    <span class="cd-error-message">格式错误!</span>

                </p>
                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">新密码</label>
                    <input class="full-width has-padding has-border" name="password2" id="signup-password2" type="password"  placeholder="请输入密码">
                    <span class="cd-error-message">格式错误!</span>

                </p>
                <p class="fieldset">
                    <input class="full-width" type="submit" value="修改密码">

                </p>
            </form>

        <% if(ftname.equals(user)==false)
            out.println("-->");
        else
           out.println("<!--");
        %>

<%if(user.equals("null"))
    out.println("<!--");

%>
        <p class="fieldset">

            <a style="
                          display: inline-block;
                          cursor:pointer;


                          font-size: 30px;
                          color: #3277fc;" href="htdl/sixin.jsp?ftname=<%=ftname%>&user=<%=user%>">私信</a>

        </p>
            <%if(user.equals("null"))
                out.println("-->");
            %>

       <% if(ftname.equals(user))
       out.println("-->");
       %>

        <p class="fieldset" >
            <a style="
                          display: inline-block;
                          cursor:pointer;


                          font-size: 30px;
                          color: #3277fc;" href="index.jsp">首页</a>
        </p>
        </div>
    </div> <!-- cd-user-modal -->






</div> <!-- cd-user-modal -->
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/main.js"></script> <!-- Gem jQuery -->
</body>
</html></html>

