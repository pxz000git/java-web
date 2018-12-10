package com.foda.web.servlet.filter.auto_login.controller.filter_permission;

import com.foda.web.servlet.filter.auto_login.domain.User;
import com.foda.web.servlet.filter.auto_login.service.UserService;
import com.foda.web.servlet.filter.auto_login.service.impl.UserServiceImpl;
import com.foda.web.servlet.filter.auto_login.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author pxz
 * @ date 2018/12/7 0007-下午 3:31
 */
public class MyPermission implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            //先判断，现在session中还有没有值
            User user = (User) request.getSession().getAttribute("user");
            //有效
            if(user != null){
                System.out.println("session中有值");
                filterChain.doFilter(servletRequest,servletResponse);
                request.getRequestDispatcher("index_filter.jsp").forward(request,response);
            }
            //session失效
            else {
                System.out.println("session失效");
                //查看cookie
                //从请求中取出cookie
                Cookie[] cookies = request.getCookies();
                Cookie cookie = CookieUtils.findCookie(cookies, "check");
                if(cookie == null){
                    System.out.println("第一次登录");
                    //第一次登录,放行
                    filterChain.doFilter(servletRequest,servletResponse);
                    //response.sendRedirect("login.jsp");

                }else{
                    //不是第一次登录
                    System.out.println("不是第一次登录");
                    String value = cookie.getValue();
                    String username = value.split("#")[0];
                    String password = value.split("#")[1];


                    UserService service = new UserServiceImpl();
                    //登录
                    user = service.login(username,password);
                    System.out.println(user);
                    //存到session中，方便下次还可以用
                    request.getSession().setAttribute("user",user);

                    filterChain.doFilter(servletRequest,servletResponse);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
            //出现异常放行，防止异常导致用户页面空白
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
