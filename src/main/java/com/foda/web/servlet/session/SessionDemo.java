package com.foda.web.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session 是一种基于Cookie的一种会话机制
 *  数据存放在服务器端
 * @author pxz
 * @date 2018/11/28 0028-下午 1:42
 */
public class SessionDemo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        //得到会话id
        String id = session.getId();

        //存值
        session.setAttribute("a","a");

        //取值
        Object a = session.getAttribute("a");

        //移除值
        session.removeAttribute("a");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
