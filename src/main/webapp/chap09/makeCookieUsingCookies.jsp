<%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-26
  Time: 오후 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="com.example.util.Cookies" %>
<%
    response.addCookie(Cookies.createCookie("name", "sbkim"));
    response.addCookie(Cookies.createCookie("id", "sbsbid", "/chap09", -1));
%>
<html>
<head>
    <title>Utils 사용 예시</title>
</head>
<body>
Cookies 를 사용해서 쿠키 생성
<br/>
<a href="readCookieUsingCookies.jsp">쿠키 확인하러 가기</a>
</body>
</html>
