<%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/2/2
  Time: 12:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh" class="no-js">
<head>
    <base href="<%=basePath%>"/>
    <title>登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->
    <%
        if(request.getSession().getAttribute("message_l")!=null)
        {
            out.println("<script type=\"text/javascript\" language=\"javascript\">\n" +
                    "alert(\""+request.getSession().getAttribute("message_l")+"\");\n" +

                    "</script>\n" +
                    "\n");
        }
    %>
</head>

<body>

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
    top: 0;
    left:calc(30%);
    right: calc(35%);
		"  class="cd-user-modal is-visible"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container" >
        <ul class="cd-switcher">
            <li><a href="#0" class="selected">账号密码登录</a></li>
           <!-- <li><a href="#0">验证码登录</a></li>-->
        </ul>


            <form class="cd-form " action="/login" method="post">

                <p class="fieldset">
                    <label class="image-replace cd-username" >账户名</label>
                    <input class="full-width has-padding has-border"name="username" id="sigin-name" type="phone" placeholder="请输入账户名">
                    <span class="cd-error-message">账户名错误</span>
                </p>
                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">密码</label>
                    <input class="full-width has-padding has-border" name="password" id="signup-password" type="text"  placeholder="请输入密码">
                    <span class="cd-error-message">格式错误!</span>

                </p>
                <p class="fieldset">
                    <input type="checkbox" id="remember-me" checked>
                    <label for="remember-me">记住密码</label>
                </p>
                <p class="fieldset">
                    <input class="full-width" type="submit" value="登录">
                    <a style="
                          display: inline-block;
                          position: absolute;
                          right: 0px;
                          cursor:pointer;
                          bottom: -22px;
                          font-size: 14px;
                          color: #3277fc;" href="htdl/regist.jsp">注册</a>
                </p>
            </form>

    </div> <!-- cd-user-modal -->

    <%@  include file="/footer.jsp" %>





</div> <!-- cd-user-modal -->
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>
<%request.getSession().removeAttribute("message_l");%>