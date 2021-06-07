<%--
  Created by IntelliJ IDEA.
  User: ashuai
  Date: 2021/5/16
  Time: 7:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
<% session.invalidate(); %>
<jsp:forward page="/index.jsp"></jsp:forward>
</body>
</html>
