package com.foda.web.Ajax;

import com.foda.web.Ajax.dao.UserDao;
import com.foda.web.Ajax.dao.impl.UserDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author pxz
 * @date 2018/11/29 0029-上午 11:17
 */
public class CheckUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //检测是否存在
        String name = req.getParameter("name");



        try {
            UserDao dao = new UserDaoImpl();
            boolean isExist = dao.checkUser(name);
        //通知页面，到底有还是没有
            if(isExist){
                resp.getWriter().println(1);//1代表存在用户
            }else{
                resp.getWriter().println(2);//2代表不存在用户
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
