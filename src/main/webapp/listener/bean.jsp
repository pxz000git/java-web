<%@ page import="com.foda.web.servlet.listener.listener_bean.BeanDemo" %>
<%@ page import="com.foda.web.servlet.listener.listener_activation.BeanDemo02" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4 0004
  Time: 下午 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //对象绑定session
    //BeanDemo beanDemo = new BeanDemo();
    //beanDemo.setName("zhangsan");
    //
    //session.setAttribute("bean",beanDemo);
    //
    //session.removeAttribute("bean");

    //session里的值钝化、活化
    BeanDemo02 beanDemo02 = new BeanDemo02();
    beanDemo02.setName("zhangsan");
    session.setAttribute("bean",beanDemo02);
%>
</body>
</html>
