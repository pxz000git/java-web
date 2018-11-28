package com.foda.web.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pxz
 * @date 2018/11/28 0028-下午 2:19
 */
public class CarServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String[] items = {"iphone7","iphone8","iphone9","iphone10","小米"};

        //获取要添加到购物车的商品id
        int id = Integer.valueOf(req.getParameter("id"));

        String name = items[id];


        //获取购物车存放东西的session
        HttpSession session = req.getSession();

        //把一个map对象存放到session中，并保证只存一次
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
        if(map == null){
            map = new LinkedHashMap<String, Integer>();
            session.setAttribute("cart",map);
        }
        //判断购物车有没有该商品
        //商品:商品名，数量
        if(map.containsKey(name)){
            map.put(name,map.get(name) + 1);
        }else{
            map.put(name,1);
        }

        //输出，跳转
        resp.getWriter().write("<a href = 'product_list.jsp'><h3>继续购物</h3></a><br>");
        resp.getWriter().write("<a href = 'car.jsp'><h3>购物结算</h3></a><br>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
