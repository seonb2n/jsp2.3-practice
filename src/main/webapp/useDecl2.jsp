<%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-23
  Time: 오후 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public int subtract(int a, int b) {
        int c = a - b;
        return c;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int value1 = 3;
    int value2 = 9;
    int addResult = add(value1, value2);
    int subtractResult = subtract(value1, value2);
%>

<%= value1%> + <%= value2%> = <%= addResult%>
<br>
<%= value1%> - <%= value2%> = <%= subtractResult%>
</body>
</html>
