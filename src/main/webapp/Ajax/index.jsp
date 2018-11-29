<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 下午 4:46
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
        };

        function get(){
            var request = ajaxFunction();

            //发送请求
            request.open("GET" ,"/ajax?name=zhangsan&age=18" ,true );

            //获取响应,类似监听，一旦准备的状态发生了改变，则执行function().
            request.onreadystatechange = function(){
                //request.readyState == 4表示已经能够正常处理
                //request.status == 200表示状态码是否是200
                if(request.readyState == 4 && request.status == 200){
                    //弹出响应信息
                    alert(request.responseText)

                }
            }

            request.send();
        }
    </script>
</head>
<body>
<h3><a href="" onclick="get()">Ajax的Get请求</a></h3>
</body>

</html>
