package com.foda.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/26 0026-上午 11:04
 */
public class HelloServlet implements Servlet{
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet service");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("servlet destroy");
    }
}
