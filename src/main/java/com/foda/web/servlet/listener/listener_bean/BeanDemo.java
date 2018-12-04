package com.foda.web.servlet.listener.listener_bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 4:28
 */
public class BeanDemo implements HttpSessionBindingListener{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("对象被绑定进来了");
    }

    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("对象解除绑定");

    }
}
