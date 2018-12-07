package com.foda.web.servlet.filter.auto_login.utils;

import javax.servlet.http.Cookie;

/**
 * @author pxz
 * @date 2018/11/26 0026-下午 4:48
 */
public class CookieUtils {/**
 * 从一个cookie数组中找到具体我们想要的cookie对象
 * @param cookies
 * @param name
 * @return
 */
public static Cookie findCookie(Cookie[] cookies , String name){
    if(cookies != null){
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
    }
    return null;
}
}
