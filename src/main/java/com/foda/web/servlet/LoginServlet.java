package com.foda.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ServletContext 的作用范围
 只要在这个项目里面，都可以取。 只要同一个项目。 A项目 存， 在B项目取，是取不到的？ ServletContext对象不同
 * @author pxz
 * @date 2018/11/26 0026-下午 12:00
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("userName="+username+"==password="+password);

        //校验数据
        //想客户端输出内容
        PrintWriter writer = resp.getWriter();

        if("admin".equals(username) && "123".equals(password)){
            System.out.println("登录成功");

            //成功就在页面打印login_success
            writer.write("login_success");

            //1. 成功的次数累加
            //获取以前存的值 ， 然后在旧的值基础上  + 1
            Object obj;
            obj = getServletContext().getAttribute("count");

            //默认就是0次
            int totalCount = 0;
            if(obj != null) {
                totalCount = (Integer) obj;
            }

            System.out.println(String.format("已知登录成功的次数是：%d",totalCount));

            //给这个count赋新的值
            getServletContext().setAttribute("count", totalCount+1);

            //2. 跳转到成功的界面
            //设置状态码? 重新定位 状态码
            resp.setStatus(302);
            //定位跳转的位置是哪一个页面。
            resp.setHeader("Location", "login_success.html");
        }else {
            writer.write("login failed");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
