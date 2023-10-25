<%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-25
  Time: 오후 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="1kb" autoFlush="false" %>
<html>
<head>
    <title>autoFlush 속성값 false 예제 </title>
</head>
<body>
<% for (int i = 0; i < 1000; i++) { %>
1234
<% } %>
</body>
</html>
