package com.foda.web.servlet.cookie;

import com.foda.web.servlet.cookie.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author pxz
 * @date 2018/11/26 0026-下午 4:52
 */
public class CookieDemo2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        if("admin".equals(username) && "123".equals(password)){
            Cookie[] cookies = req.getCookies();

            Cookie cookie = CookieUtils.findCookie(cookies, "last");

            if(cookie == null){
                //第一次登陆
                Cookie c = new Cookie("last", System.currentTimeMillis()+"");
                c.setMaxAge(60*60); //一个小时
                resp.addCookie(c);

                resp.getWriter().write("欢迎您, "+username);
            }
            else{
                //取以前的cookie,第二次登陆，有cookie
                long lastVisitTime = Long.parseLong(cookie.getValue());

                //输出到界面
                resp.getWriter().write("欢迎您, "+username +",上次来访时间是："+new Date(lastVisitTime));

                //3. 重置登录的时间
                cookie.setValue(System.currentTimeMillis()+"");
                resp.addCookie(cookie);

            }
        }
        else{
            resp.getWriter().write("登陆失败 ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
