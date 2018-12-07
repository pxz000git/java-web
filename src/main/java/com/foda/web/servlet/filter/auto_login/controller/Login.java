package com.foda.web.servlet.filter.auto_login.controller;

import com.foda.web.servlet.filter.auto_login.domain.User;
import com.foda.web.servlet.filter.auto_login.service.UserService;
import com.foda.web.servlet.filter.auto_login.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 5:31
 */
public class Login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String check = req.getParameter("auto_login");

        System.out.println(String.format("check is 'on' or 'null' %s",check));
        System.out.println(String.format("username is %s, password is %s",username,password));

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if(user != null){

            //页面提交上来的时候，是否选择了自动登录
            if("on".equals(check)){
                //发送cookie给客户端
                Cookie cookie = new Cookie("check", username + "#" + password);
                //一天有效
                cookie.setMaxAge(60*60*24*7);
                //cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);

            }
            System.out.println("登录成功");
            //登录成功
            req.getSession().setAttribute("user",user);
            //重定向到首页页
            resp.sendRedirect("index.jsp");

        }
        else{
            System.out.println("登录失败");
            //跳转到登录页
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
