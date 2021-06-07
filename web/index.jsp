<%@ page import="com.web6.entity.tiezi" %>
<%@ page import="com.web6.service.ListService" %>
<%@ page import="com.web6.service.impl.ListServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web6.entity.Gaozhi" %>
<%@ page import="com.web6.entity.User" %>
<%@ page import="com.web6.entity.BK" %>
<%@ page import="com.web6.repository.ListRepository" %>
<%@ page import="com.web6.repository.impl.ListRepositoryImpl" %><%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/4/18
  Time: 4:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%response.setHeader( "refresh ", "20");%>
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

<%!
  List<tiezi> show(){
    ListService listServicem=new ListServiceImpl();
    List<tiezi> listm=listServicem.findAll();

    return listm;
  }
%>

<%
  User userm=(User) request.getSession().getAttribute("user");
  String namem=null;
  Integer uid=null;
  String  urlm="/htdl/login.jsp";

  if(userm!=null)
  {
    namem=userm.getUsername();
    uid=userm.getId();
    urlm="/htdl/usercenter.jsp?usercentername="+namem+"&username="+namem;
  }

  List<tiezi> listm=(List<tiezi>) request.getSession().getAttribute("lists");

  if(listm==null){ //可能有漏洞
  listm=show();



  }
%>
<html>
<head>

  <title>上海大学旅游论坛首页</title>
  <link rel="stylesheet" href="bootStrap/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="bootStrap/css/bootstrap-theme.min.css">
  <script src="bootStrap/js/bootstrap.min.js" type="application/javascript"></script>
  <%
    if(request.getSession().getAttribute("message_i")!=null)
    {
      out.println("<script type=\"text/javascript\" language=\"javascript\">\n" +
              "alert(\""+request.getSession().getAttribute("message_i")+"\");\n" +

              "</script>\n" +
              "\n");
    }
  %>
</head>
<body>
<div style="position:fixed;z-index: 1;top: 0;width: 100%;">
  <%@  include file="top.jsp" %>

</div>









<div class="container-fluid main profile" style="position: absolute ;top: 50px">
  <div class="row"  style="overflow-y: scroll">
    <div class="col-lg-3 col-mg-12 col-sm-12 col-xs-12" >
      <div style="background-color: #1E9FFF; border-radius: 25px;position:fixed;z-index: 1;top: 100px;width: 20% ;height: auto" >
        <h3 style="color:#FFFFFF; text-align: center">   通知</h3>
      </div>
      <%!
        List<Gaozhi> showG(){
          ListService listServiceG=new ListServiceImpl();
          List<Gaozhi> listG= listServiceG.findAllG();

          return listG;
        }

      %>
      <div style="position: absolute;width: 20%" ></div>
      <div  style=" border-radius: 25px;position:fixed;z-index: 1;top: 200px;width: 20%">
        <div class="well" >
          <%

            List<Gaozhi> listg=showG();

            for(int i=0;i<listg.size();i++){

              out.println("<div class=\"media\">");
              int j=i+1;
              out.println("<div class=\"media-body\"> <a href=\"htdl/Gaozhi.jsp?Gid="+listg.get(i).getGid()+"\"><h4 class=\"media-heading\">"+j+listg.get(i).getGtitle()+"</h4></a>");
              out.println("</div>");
              out.println("</div>");

            }
          %>
        </div>
      </div>

      <div style="background-color: #1E9FFF; border-radius: 25px;position:fixed; bottom:50px; z-index: 1;width: 20% ;height: auto" >


        <%
          for(int i=0;i<listbk.size();i++) {
            out.println("<a style=\"color:#FFFFFF; \" ");

            out.println(" href=\"/SearchBK?BID="+listbk.get(i).getBid()+"&username="+namem+"\"><h3 style=\"text-align: center\">");
            out.println(listbk.get(i).getBname());
            out.println("</h3></a>");
          }
        %>
      </div>

    </div>
    <div  class="col-lg-6 col-md-12 col-sm-12 col-xs-12"  >
      <h2><span class="glyphicon glyphicon-list" aria-hidden="true" style="color:#FFFFFF;background-color: #1E9FFF;border-radius: 25px"></span>帖子</h2>

      <%
        for(int i=0;i<listm.size();i++)
        {
          String zw=listm.get(i).getZhengwen();
          out.println("<div class=\"well\">");
          out.println("<div class=\"media\">");
          out.println("<div class=\"media-left\">");
          out.println("<a >\n" +
                  "      <img  style=\"border-radius: 25px;width: 50px;height: 50px\" width= 50px src=\"upload/"+listm.get(i).getName()+".png\" onerror=\"javascript:this.src='upload/cd-icon-username.png';\">\n" +
                  "    </a></div>");

          out.println("<div class=\"media-body\"><a href=\"htdl/tiezi.jsp?tzid="+
                  listm.get(i).getTzid()+"&username="+namem+"\"><h4 class=\"media-heading\">"+listm.get(i).getTitle()+"</h4></a>");
          out.println("<br/>");
          out.println("<tr><a href=\"htdl/usercenter.jsp?usercentername="+listm.get(i).getName()+"&username="+namem+"\">"+listm.get(i).getName()+"</a>");
          out.println("赞👍："+listm.get(i).getZan());
          out.println(" </br> 创建时间："+listm.get(i).getTcreate_time()+"</div>");

          out.println("</div>");
          out.println("<p></p>");

          out.println("<p></p>");

          out.println("</div>");

        }%>
    </div>
    <div class="col-lg-3 col-mg-12 col-sm-12 col-xs-12"  >

      <div style="background-color: #1E9FFF; border-radius: 25px;position:fixed;z-index: 1;top: 100px;width: 20% ;height: auto" >
        <h3 style="color:#FFFFFF; text-align: center">   热门</h3>

      </div>
      <%!
        List<tiezi> showRe(){
          ListService listServiceR=new ListServiceImpl();
          List<tiezi> listR= listServiceR.findersou();

          return listR;
        }

      %>
      <div  style=" border-radius: 25px;position:fixed;z-index: 1;top: 200px;width: 20%">
        <div class="well" >
          <%

            List<tiezi> listr=showRe();
            request.getSession().setAttribute("listr",listr);
            for(int i=0;i<10;i++){

              out.println("<div class=\"media\">");
              int j=i+1;
              out.println(" <a href=\"htdl/tiezi.jsp?tzid="+
                      listr.get(i).getTzid()+"&username="+namem+"\"><h4 class=\"media-heading\">");
              out.println(j+listr.get(i).getTitle());
              if(listr.get(i).getTop()==1)
              {
                out.println("(推荐)");
              }
              out.println("</h4></a>");
              out.println("</div>");

            }
          %>
        </div>

      </div>
    </div>
  </div>

</div>
</body>
</html>
<%
  request.getSession().setAttribute("user",userm);
  request.getSession().removeAttribute("lists");
  request.getSession().removeAttribute("lists2");
  request.getSession().removeAttribute("message_i");
  //request.getSession().removeAttribute("user");
%>