<%@ page import="com.web6.entity.BK" %>
<%@ page import="com.web6.repository.ListRepository" %>
<%@ page import="com.web6.repository.impl.ListRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/3/29
  Time: 9:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<BK> showBK(){
        ListRepository listRepository=new ListRepositoryImpl();
        List<BK> listBK= listRepository.findBKall();

        return listBK;
    }
%>
<%

    List<BK> listbk=showBK();
%>
<!DOCTYPE html>
<%
    if(request.getSession().getAttribute("message_zw")!=null)
    {
        out.println("<script type=\"text/javascript\" language=\"javascript\">\n" +
                "alert(\""+request.getSession().getAttribute("message_zw")+"\");\n" +

                "</script>\n" +
                "\n");
    }
%>
<%request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html >
<head>
    <meta charset="utf-8">
    <title>发帖</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"   media="all">
    <link rel="stylesheet" href="htdl/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="htdl/css/style.css"> <!-- Gem style -->
    <script src="<%=basePath%>js/modernizr.js"></script> <!-- Modernizr -->
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
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
<%
    String username=(String) request.getParameter("namem");

    Integer uid=new Integer(request.getParameter("uid"));


%>
<div style="z-index: 10000;
    position: absolute;
    top: 20px;
    bottom: 0;
    left:calc(20%);
    right: calc(20%);
    background-color: #FFFFFF;
    overflow-y: scroll;


		"  class="cd-user-modal is-visible">

<form action="/addtiezi?namem=<%=username%>&uid=<%=uid%>" method="post">

    <input name="title" id="titlt" type="text" width="100%" placeholder="请输入标题" autocomplete="off">
    <select name="bk">
        <%
            for(int i=0;i<listbk.size();i++) {
                out.println("<option >"+listbk.get(i).getBname()+"</option>");
            }

        %>

    </select>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <%
        username=new String(username.getBytes(StandardCharsets.UTF_8));
        out.println("<legend>你好，亲爱的id为"+uid+"的用户"+username+"：可以开始创作了</legend>");
    %>
</fieldset>
<textarea class="layui-textarea" id="zhengwen" name="zhengwen" style="display: none">
</textarea>
<input type="submit" value="发布">
<script src="layui/layui.js"  charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use('layedit', function(){
        var layedit = layui.layedit
            ,$ = layui.jquery;
        //构建一个默认的编辑器
        var index = layedit.build('zhengwen');
        //编辑器外部操作
    });
</script>
</form>
</div>
</body>
</html>