package com.foda.web.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/28 0028-下午 1:54
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //响应数据返回乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("收到请求了");

        HttpSession session = req.getSession();

        //得到会话id
        String id = session.getId();
        System.out.println(String.format("sessionId is %s",id));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
