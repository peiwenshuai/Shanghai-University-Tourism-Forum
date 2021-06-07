<%@ page import="com.web6.entity.Sixin" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web6.repository.ListRepository" %>
<%@ page import="com.web6.repository.impl.ListRepositoryImpl" %>
<%@ page import="com.web6.service.AddSixinService" %>
<%@ page import="com.web6.service.impl.AddSixinServiceImpl" %>
<%@ page import="com.web6.repository.SixinRepository" %>
<%@ page import="com.web6.repository.impl.SixinRepositoryImpl" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/4/6
  Time: 3:03 下午
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
    <title>私信</title>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"   media="all">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->
</head>
<%
    String ftname=request.getParameter("ftname");
    String user=request.getParameter("user");
%>
<%!
    List<String> showFSl(String user){
        ListRepository listRepository=new ListRepositoryImpl();
        return listRepository.findF(user);
    }
    List<Sixin> showHSl(String user,String ftname){
        ListRepository listRepository=new ListRepositoryImpl();
        return listRepository.findW(user,ftname);
    }
    Integer findrecords(String user,String ftname){
        ListRepository listRepository=new ListRepositoryImpl();
        return listRepository.findrecordS(ftname,user);
    }
%>

<%
    SixinRepository sixinRepository=new SixinRepositoryImpl();
    sixinRepository.RecordS(ftname,user);
   List<String> listSxw=showFSl(user);
   List<Sixin> listhSl=showHSl(user,ftname);
%>
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

    top:0px;
    height: 100%;
    left:calc(20%);
    right: calc(20%);
    overflow-y: scroll;
    background-color: white;
		"  class="cd-user-modal is-visible"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container" style="height: 100%; width:30%; right: calc(-5%);float: left " >
        <div class="cd-user-modal-container" style="height:50px; width:250px;background-color:#3277FC;">
            <br/>
            <h1 style="color: #FFFFFF">联系人列表</h1>
        </div>
        <div style="position: absolute; top: 50px">

       <% for(int i=0;i<listSxw.size();i++){

        if(findrecords(user,listSxw.get(i))>0)
        {
            out.println("<div class=\"cd-user-modal-container\" style=\"height:50px; width:150px;background-color:#36b9cc\">");

            out.println("</br>");
            out.println(" <a href=\"htdl/sixin.jsp?ftname=" + listSxw.get(i) + "&user=" + user + "\"><h4 class=\"media-heading\">" + listSxw.get(i) + "   未读条数："
                    +findrecords(user,listSxw.get(i))+"</h4></a>");
            out.println("</br>");

            out.println("</div>");
        }else {
            out.println("<div class=\"cd-user-modal-container\" style=\"height:50px; width:150px;background-color: #cccccc \">");

            out.println("</br>");
            out.println(" <a href=\"htdl/sixin.jsp?ftname=" + listSxw.get(i) + "&user=" + user + "\"><h4 class=\"media-heading\">" + listSxw.get(i) + "</h4></a>");
            out.println("</br>");

            out.println("</div>");
        }
        }
    %>
        </div>
    </div>
    <div class="cd-user-modal-container" style="height: 100%;width:60%; left: calc(7%); float: left" >

        <div style="position:absolute;left: 20px;">
            <script type="text/javascript">
                function add()
                {
                    var now = new Date();
                    var div = document.getElementById('scrolldIV');
                    div.innerHTML = div.innerHTML  + '<br />';
                    div.scrollTop = div.scrollHeight;
                }
                window.onload=add;
            </script>
            <div id="scrolldIV" style="overflow:auto; height: 400px; width: 420px; border: 1px solid #999; ">
                <% for(int i=0;i<listhSl.size();i++){
                    if(!listhSl.get(i).getUfname().equals(user)) {
                        out.println("<div class=\"cd-user-modal-container\" style=\"height:50px;background-color: #9acfea \">");


                        out.println(" <h4 class=\"media-heading\">" + listhSl.get(i).getUfname() + ":" + listhSl.get(i).getNeirong() + "</h4></a>");
                        out.println("</br>");
                        out.println("时间：" + listhSl.get(i).getS_createtime());
                        out.println("</div>");
                        out.println("</br>");
                    }else{
                        out.println("<div class=\"cd-user-modal-container\" style=\"height:50px;right: calc(-20%) ;background-color: #cccccc \">");


                        out.println(" <h4 class=\"media-heading\">" + listhSl.get(i).getUfname() + ":" + listhSl.get(i).getNeirong() + "</h4></a>");
                        out.println("</br>");
                        out.println("时间：" + listhSl.get(i).getS_createtime());
                        out.println("</div>");
                        out.println("</br>");
                    }

                }%>
            </div>



            <form class="cd-form " action="/Sixin" method="post">


                <input type="hidden" name="ftname" value="<%=ftname%>" >
                <input type="hidden" name="user" value="<%=user%>" >

                <textarea class="layui-textarea" id="sixin" name="neirong" style="display: none;height: 100px;width: 100px">

</textarea>
                <script src="<%=basePath%>layui/layui.js"  charset="utf-8"></script>
                <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
                <script>
                    layui.use('layedit', function(){
                        var layedit = layui.layedit
                            ,$ = layui.jquery;

                        //构建一个默认的编辑器
                        var index = layedit.build('sixin',{height:50});

                        //编辑器外部操作

                    });
                </script>


                    <input class="full-width" type="submit" value="发送">


            </form>




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
</html>
