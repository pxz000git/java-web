package com.foda.web.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie 服务器发送给客户端，并且保存在客户端上的一份小数据(不安全),有大小限制-->衍生出session
 * @author pxz
 * @date 2018/11/26 0026-下午 4:33
 */
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // cookie 服务器发送给客户端，并且保存在客户端上的一份小数据

        resp.setContentType("text/html;charset=utf-8");

        //发送cookie给客户端
        Cookie cookie = new Cookie("a","a_value");

        //设置生命周期
        //正值 ： 表示 在这个数字过后，cookie将会失效。
        //负值： 关闭浏览器，那么cookie就失效， 默认值是 -1
        cookie.setMaxAge(60 * 60 * 24 * 7);

        //赋值新的值
        //cookie.setValue(newValue);

        //用于指定只有请求了指定的域名，才会带上该cookie
        //cookie.setDomain(".foda.com");

        //只有访问该域名下的cookieDemo的这个路径地址才会带cookie
        //cookie.setPath("/CookieDemo");

        // 给到response,添加一个 cookie
        resp.addCookie(cookie);
        resp.getWriter().write("请求成功了");


        //获取客户端带过来的cookie
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(String.format("name is %s, value is %s",name,value));
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
