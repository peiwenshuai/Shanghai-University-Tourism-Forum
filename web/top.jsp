<%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/4/9
  Time: 4:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>top</title>
    <link rel="stylesheet" href="bootStrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootStrap/css/bootstrap-theme.min.css">
    <script src="<%=basePath%>bootStrap/js/bootstrap.min.js" type="application/javascript"></script>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>

            </button>
            <a class="navbar-brand" href="index.jsp">上海大学旅游论坛</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="htdl/regist.jsp">注册<span class="sr-only">(current)</span></a></li>


            </ul>
            <form class="navbar-form navbar-left" action="/search" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="search" placeholder="Search" autocomplete="off">

                </div>
                <button   style="background-color: #1E9FFF" type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <%

                    if(userm!=null) {
                        out.println("<li><a href=" + urlm + ">" + namem + "</a></li>");
                        out.println("<li><a href=\"htdl/sixin.jsp?ftname="+""+"&user="+namem+"\">"+"私信中心"+"</a></li>");

                    }
                    else{
                        out.println("<li><a href="+urlm+">登录</a></li>");
                    }
                %>
                <%
                    String addurl=null;
                    if(userm!=null){
                        addurl="add_t.jsp?namem="+namem+"&uid="+uid;
                        out.println("<li><a href=\""+addurl+"\">发布帖子</a></li>");
                    }
                    String index="logout.jsp";
                    if(userm!=null){
                        out.println("<li><a href=\""+index+"\">退出登录</a></li>");
                    }
                %>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
