<%--
  Created by IntelliJ IDEA.
  User: seonbin
  Date: 2023-10-25
  Time: 오후 6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>클라이언트 및 서버 정보</title>
</head>
<body>
클라이언트 IP = <%=request.getRemoteAddr() %><br>
요청 정보 길이 = <%=request.getContentLength() %><br>
요청 정보 인코딩 = <%=request.getCharacterEncoding() %><br>
요청 정보 컨텐츠타입 = <%=request.getContentType() %><br>
요청 정보 프로토콜 = <%=request.getProtocol() %><br>
요청 정보 전송방식 = <%=request.getMethod() %><br>
요청 URI = <%=request.getRequestURI() %><br>
컨첵스트 경로 <%=request.getContextPath() %><br>
서버 이름 <%=request.getServerName() %><br>
서버 포트 <%=request.getServerPort() %><br>
</body>
</html>
