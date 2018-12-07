package com.foda.web.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 2:49
 */
public class FilterDemo02 implements Filter{
    public void init(FilterConfig filterConfig){
        System.out.println("初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("过滤器02...");

        //执行下一个servlet或filter
        filterChain.doFilter(servletRequest,servletResponse);

    }

    public void destroy() {
        System.out.println("销毁");
    }
}
