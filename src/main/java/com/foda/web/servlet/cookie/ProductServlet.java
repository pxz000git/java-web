package com.foda.web.servlet.cookie;

import com.foda.web.servlet.cookie.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/26 0026-下午 6:12
 */
public class ProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到当前用户准备浏览的商品ID
        String id = req.getParameter("id");

        Cookie[] cookies = req.getCookies();

        Cookie cookie = CookieUtils.findCookie(cookies, "history");

        if(cookie == null){
            //第一次浏览
            //响应返回cookie
            Cookie c = new Cookie("history", id);
            resp.addCookie(c);

        }else{
            //第二次
            //1.获取以前的cookie，因为以前的cookie包含了浏览记录
            String ids = cookie.getValue();

            //2.让现在浏览的商品和以前浏览的商品形成cookie新的值
            cookie.setValue(id+"#"+ids);
            resp.addCookie(cookie);
        }
        //跳转到具体页面
        resp.sendRedirect("product_info.htm");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
