<%@ page import="com.example.MemberInfo" %><%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-26
  Time: 오후 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberInfo memberInfo = new MemberInfo("id_123", "name_123");
    session.setAttribute("memberInfo", memberInfo);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% MemberInfo memberInfo2 = (MemberInfo) session.getAttribute("memberInfo"); %>
<%=memberInfo2.getName() %>
</body>
</html>
