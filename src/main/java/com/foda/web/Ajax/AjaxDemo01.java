package com.foda.web.Ajax;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/28 0028-下午 4:44
 */
public class AjaxDemo01 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(String.format("收到请求: name is %s,age is %s",name,age));

        resp.getWriter().write("收到了请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("来了一个Post请求");
        doGet(req,resp);
    }
}
