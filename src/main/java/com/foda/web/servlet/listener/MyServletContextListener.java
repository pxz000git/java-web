package com.foda.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 2:51
 */
public class MyServletContextListener implements ServletContextListener{

    //初始化的时候调用
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext初始化");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext销毁");
    }
}
