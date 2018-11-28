<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 下午 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>商品</h2>
<%
    //先获取map
    Map<String, Integer> map = (Map<String, Integer>)session.getAttribute("cart");

    //遍历map
    if(map != null){
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            Integer value = entry.getValue();
%>
<h3>名称：<%=key%> 数量：<%=value%></h3><br>
<%
        }
    }
%>
<a href="cleanCar"><h4>清空购物车</h4></a>
</body>
</html>
