<%@ page import="com.web6.entity.tiezi" %>
<%@ page import="com.web6.service.ListService" %>
<%@ page import="com.web6.service.impl.ListServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web6.service.FindTieziService" %>
<%@ page import="com.web6.service.impl.FindtieziServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="com.web6.repository.TieziRepository" %>
<%@ page import="com.web6.repository.impl.AddTieziRepositoryImpl" %>
<%@ page import="com.web6.service.ListPinlunTService" %>
<%@ page import="com.web6.service.impl.FindTpinlunServiceImpl" %>
<%@ page import="com.web6.entity.Pinlun" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/4/1
  Time: 9:10 上午
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!List<Pinlun> findtpinlun(Integer tzid){
    ListPinlunTService listPinlunTService=new FindTpinlunServiceImpl();
     return listPinlunTService.FindTpinlun(tzid);
}
%>
<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
Integer tzid=Integer.valueOf(request.getParameter("tzid")).intValue();
String namem=request.getParameter("username");
List<Pinlun> listp=findtpinlun(tzid);
System.out.println(namem);
%>
<%!

    tiezi findtiezi(Integer tzid){
        TieziRepository FindtieziRepository=new AddTieziRepositoryImpl();

        Date tcreat_time=new Date(System.currentTimeMillis());

        tiezi tiezim=FindtieziRepository.Findtiezi(tzid, " n",  "zhengwen",
                "tphoto",  0,  0, 0, tcreat_time,   0, 0,  " ");
        return tiezim;
    }
%>
<%
    tiezi Tz=null;
    if(tzid!=null)
    {
        Tz=findtiezi(tzid);
    }
    else {
        System.out.println("kong");
    }

%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>帖子</title>
    <link rel="stylesheet" href="layui/css/layui.css"   media="all">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->

    <script src="<%=basePath%>bootStrap/js/bootstrap.min.js" type="application/javascript"></script>
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
    bottom: 0;
    left:calc(20%);
    right: calc(20%);
    background-color: #FFFFFF;
    overflow-y: scroll;


		"  class="cd-user-modal is-visible" > <!-- this is the entire modal form, including the background -->
<div style="margin: 10% auto">
        <div  style="width: 90% ;margin:5% auto" >


    <h1 style="font-size: xxx-large" align="center"><%=Tz.getTitle()%></h1>
<br/>
            <h4>作者：<%=Tz.getName()%></h4>
<br/>
                <p><%=Tz.getZhengwen()%></p>
<br/>
                <form action="/zan" method="post">
                    <input type="hidden" name="ID" value="<%=Tz.getTzid()%>">
                    <input type="submit" value="👍<%=Tz.getZan()%>"  >
                </form>

<br/>创建时间：<%=Tz.getTcreate_time()%>;

        </div>
<div style="width: 90% ;margin:5% auto ">
<form action="/pinlun?namem=<%=namem%>&tzid=<%=tzid%>" method="post">


    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <%


            out.println("<legend>你好，可以评论了</legend>");

        %>

    </fieldset>

    <textarea class="layui-textarea" id="pinlun" name="pinlun" style="display: none">

</textarea>

    <input type="submit" value="发布">





    <script src="<%=basePath%>layui/layui.js"  charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
    <script>
        layui.use('layedit', function(){
            var layedit = layui.layedit
                ,$ = layui.jquery;

            //构建一个默认的编辑器
            var index = layedit.build('pinlun');

            //编辑器外部操作




        });
    </script>
</form>
</div>

<div style="width: 90% ;margin:5% auto">
<%if(listp!=null)
{
    for(int i=0;i<listp.size();i++)
    {
        out.println("<div class=\"well\" >");
        int j=i+1;
        out.println("<div>");
        out.println("评论"+j+"："+listp.get(i).getPl());
        out.println("<br/>");
        out.println("<a href=\"htdl/usercenter.jsp?usercentername="+listp.get(i).getPlname()+"&username="+namem+"\">"+listp.get(i).getPlname()+"</a>");
        out.println("创建时间："+listp.get(i).getCreate_time());
        out.println("</div>");
       out.println("</div>");

    }
}
%>

</div>



</div>

</div> <!-- cd-user-modal -->
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>
