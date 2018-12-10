<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/8 0008
  Time: 上午 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>首页</h3>
<a href="filter_test.jsp">跳转到过滤测试页filter_test</a><br>
<form action="../" method="post">
    账号:<input type="text" name="username"/><br>
    密码:<input type="text" name="password"/><br>
    <input type="checkbox" name="auto_login">自动登录</input><br>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
