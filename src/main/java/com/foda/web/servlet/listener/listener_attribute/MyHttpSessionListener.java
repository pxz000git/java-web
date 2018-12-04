package com.foda.web.servlet.listener.listener_attribute;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 4:12
 */
public class MyHttpSessionListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性添加");

    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性移除");

    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性提换");

    }
}
