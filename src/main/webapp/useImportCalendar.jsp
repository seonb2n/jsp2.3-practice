<%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-23
  Time: 오후 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Calendar cal = Calendar.getInstance(); %>
오늘은
<%= cal.get(Calendar.YEAR) %> 년
<%= cal.get(Calendar.MONTH) %> 월
<%= cal.get(Calendar.DATE) %> 일
</body>
</html>
