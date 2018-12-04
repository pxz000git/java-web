package com.foda.web.servlet.listener.listener_activation;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 4:43
 */
public class MyHttpSessionActivation implements HttpSessionActivationListener {

    /**
     *session被钝化：就是把session中的值存到硬盘
     * @param httpSessionEvent
     */
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被钝化");
    }

    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

        System.out.println("活化");
    }
}
