package com.foda.web.servlet.unicode;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 请求：
 * 客户端提交数据给服务器端，如果数据中带有中文的话，有可能会出现乱码情况，那么可以参照以下方法解决。
     如果是GET方式

         代码转码 String username = request.getParameter("username"); String password = request.getParameter("password");

         System.out.println("userName="+username+"==password="+password);

         //get请求过来的数据，在url地址栏上就已经经过编码了，所以我们取到的就是乱码，
         //tomcat收到了这批数据，getParameter 默认使用ISO-8859-1去解码

         //先让文字回到ISO-8859-1对应的字节数组 ， 然后再按utf-8组拼字符串
         username = new String(username.getBytes("ISO-8859-1") , "UTF-8");
         System.out.println("userName="+username+"==password="+password);

         直接在tomcat里面做配置，以后get请求过来的数据永远都是用UTF-8编码。
         可以在tomcat里面做设置处理 conf/server.xml 加上URIEncoding="utf-8"


     如果是POST方式

         这个说的是设置请求体里面的文字编码。  get方式，用这行，有用吗？ ---> 没用
         request.setCharacterEncoding("UTF-8");

         这行设置一定要写在getParameter之前。
 响应：
         HttpServletResponse
         负责返回数据给客户端。
         输出数据到页面上

         //以字符流的方式写数据
         //response.getWriter().write("<h1>hello response...</h1>");

         //以字节流的方式写数据
         response.getOutputStream().write("hello response2222...".getBytes());
         响应的数据中有中文，那么有可能出现中文乱码
         以字符流输出
         response.getWriter()
         //1. 指定输出到客户端的时候，这些文字使用UTF-8编码
         response.setCharacterEncoding("UTF-8");

         //2. 直接规定浏览器看这份数据的时候，使用什么编码来看。
         response.setHeader("Content-Type", "text/html; charset=UTF-8");

         response.getWriter().write("我爱黑马训练营...");
         以字节流输出
         response.getOutputStream()
         //1. 指定浏览器看这份数据使用的码表
         response.setHeader("Content-Type", "text/html;charset=UTF-8");

         //2. 指定输出的中文用的码表
         response.getOutputStream().write("我爱深圳黑马训练营..".getBytes("UTF-8"));


         --------------------------------------------
         不管是字节流还是字符流，直接使用一行代码就可以了。
         response.setContentType("text/html;charset=UTF-8");

         然后在写数据即可。
 * @author pxz
 * @date 2018/11/26 0026-下午 1:04
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("来了一个post请求...");
        // 如果是POST方式
        // 这行设置一定要写在getParameter之前。
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("POST方式 : userName=" + username + "password=" + password);
        //直接在tomcat里面做配置，以后get请求过来的数据永远都是用UTF-8编码。
        //可以在tomcat里面做设置处理 conf/server.xml 加上URIEncoding="utf-8"
    }

    /**
     * 处理get请求过来的数据乱码
     */
    public void method1(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("GET方式，username=" + username + "，password=" + password);

        //get请求过来的数据，在url地址栏上就已经编过码了
        //所以我们取到的就是乱码
        //tomcat收到这批数据，getParameter默认使用ISO-8859-1去解码

        //先让文字回到IOS-8859-1对应的字节数组，然后再按utf-8拼接字符串

        try {
            username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("GET方式: username=" + username + "password=" + password);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
