package com.foda.web.servlet.filter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ author pxz
 * @ date 2018/12/3 0003-下午 6:00
 */
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("测试过滤拦截是否会执行");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(String.format("username is %s, password is %s",username,password));
        Object abc = req.getSession().getAttribute("abc");
        System.out.println(String.format("abc is %s",abc));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req,resp);
    }
}
