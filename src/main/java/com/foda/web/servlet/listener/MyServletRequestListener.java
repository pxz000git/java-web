package com.foda.web.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 3:19
 */
public class MyServletRequestListener implements ServletRequestListener{

    /**
     * HttpServletRequest-->request创建:访问服务器上的任意资源
     * @param servletRequestEvent
     */
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest初始化");
    }

    /**
     * 销毁：服务器已经对访问资源做出来响应
     * @param servletRequestEvent
     */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("ServletRequest销毁");
    }
}
