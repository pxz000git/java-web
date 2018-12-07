package com.foda.web.servlet.filter.auto_login.controller;

import com.foda.web.servlet.filter.auto_login.domain.UserBean;
import com.foda.web.servlet.filter.auto_login.utils.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @ author pxz
 * @ date 2018/12/7 0007-下午 2:04
 */
public class Register extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean bean = new UserBean();
        //注册,自己的日期转换器
        ConvertUtils.register(new MyDateConverter(), Date.class);
        Map<String, String[]> map = req.getParameterMap();

        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
