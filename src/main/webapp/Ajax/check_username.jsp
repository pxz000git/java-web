<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function  ajaxFunction(){
            var xmlHttp;
            try{ // Firefox, Opera 8.0+, Safari
                xmlHttp=new XMLHttpRequest();
            }
            catch (e){
                try{// Internet Explorer
                    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e){
                    try{
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e){}
                }
            }

            return xmlHttp;
        }
        function checkUsername(){
            //获取输入框的值
            var name = document.getElementById("name").value;
            // alert("name="+name);

            //1. 创建对象
            var request = ajaxFunction();

            //2. 发送请求
            request.open( "POST", "/check", true );

            //如果不带数据，写这行就可以了
            //request.send();

            //获取响应数据,类似监听，一旦准备的状态发生了改变，则执行function().
            request.onreadystatechange = function(){
                //request.readyState == 4表示已经能够正常处理
                //request.status == 200表示状态码是否是200
                if(request.readyState == 4 && request.status == 200){
                    var data = request.responseText;
                    if(data == 1){
                        document.getElementById("span01").innerHTML="<font color='red'>用户名不可用</font>"
                    }else{
                        document.getElementById("span01").innerHTML="<font color='green'>用户名可用</font>"
                    }

                }
            }

            //如果想带数据，就写下面的两行

            //如果使用的是post方式带数据，那么 这里要添加头， 说明提交的数据类型是一个经过url编码的form表单数据
            request.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            //带数据过去  ， 在send方法里面写表单数据。
            request.send("name="+name);
        }
    </script>
</head>
<body>
<%--<h3><a href="" onclick="checkUsername()">的请求</a></h3>--%>
<table border="1" width="500">
    <tr>
        <td>用户名</td>
        <td><input type="text" name="" id="name" onblur="checkUsername()" ><span id="span01"></span></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td>简介</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="注册"></td>
    </tr>
</table>
</body>
</html>
