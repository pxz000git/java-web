<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    学号：<input name="no"/><br>
    姓名:<input name="name"/><br>
    照片:<input type="file" name="picture"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
