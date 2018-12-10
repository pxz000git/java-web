package com.foda.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ author pxz
 * @ date 2018/12/3 0003-下午 6:13
 */
public class FilterDemo implements Filter {
    public void init(FilterConfig filterConfig){
        System.out.println("初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("拦截前---1...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;


        //执行下一个servlet或filter
        filterChain.doFilter(servletRequest,servletResponse);

        request.getSession().setAttribute("abc","abc");
        System.out.println("拦截后---2...");

    }

    public void destroy() {
        System.out.println("销毁");
    }
}
