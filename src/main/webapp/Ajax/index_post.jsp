<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 下午 5:50
  To change this template use File | Settings | File Templates.
--%>
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

        function post(){
            //1. 创建对象
            var request = ajaxFunction();

            //2. 发送请求
            request.open( "POST", "/ajax", true );

            //如果不带数据，写这行就可以了
            //request.send();

            //获取响应,类似监听，一旦准备的状态发生了改变，则执行function().
            // request.onreadystatechange = function(){
            //     //request.readyState == 4表示已经能够正常处理
            //     //request.status == 200表示状态码是否是200
            //     if(request.readyState == 4 && request.status == 200){
            //         //弹出响应信息
            //         alert(request.responseText)
            //
            //     }
            // }

            //如果想带数据，就写下面的两行

            //如果使用的是post方式带数据，那么 这里要添加头， 说明提交的数据类型是一个经过url编码的form表单数据
            request.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            //带数据过去  ， 在send方法里面写表单数据。
            request.send("name=aobama&age=19");
        }
    </script>
</head>
<body>
<h3><a href="" onclick="post()">Ajax的Post请求</a></h3>
</body>
</html>
