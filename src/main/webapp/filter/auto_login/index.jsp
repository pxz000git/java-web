<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
首页<br>
<c:if test="${not empty user}">
    欢迎您，${user.username}
</c:if>
<c:if test="${empty user}">
    <a href="login.jsp">你好，请登录！！！</a>
</c:if>
</body>
</html>
