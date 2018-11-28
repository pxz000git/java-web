package com.foda.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ServletContext 的作用范围
 只要在这个项目里面，都可以取。 只要同一个项目。 A项目 存， 在B项目取，是取不到的？ ServletContext对象不同
 * @author pxz
 * @date 2018/11/26 0026-上午 11:13
 */
public class MyHttpServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Servlet的配置参数
        //ServletConfig config = getServletConfig();
        //String number = config.getInitParameter("number");
        //if (number == null) {
        //    throw new IllegalArgumentException("servlet在配置的时候，一定要写number这个参数。。");
        //
        //} else {
        //    System.out.println(number);
        //}
        //获取Servlet的上下文
        ServletContext context = getServletContext();

        /*String path = context.getRealPath("conf.properties");
        //D:\IdeaWorkspace\java-learn\my-web\target\my-web-1.0-SNAPSHOT\conf.properties
        System.out.println(String.format("path is %s",path));*/

        try {
            Properties properties = new Properties();
            //conf.properties在resources目录下，
            InputStream resource = this.getClass().getClassLoader().getResourceAsStream("conf.properties");

            //int len;
            //byte[] bytes = new byte[1024];
            //while((len=resource.read(bytes)) != -1){
            //    System.out.println(new String(bytes,0,len));
            //}

            //InputStream resource = context.getResourceAsStream("file/conf.properties");
            properties.load(resource);
            ////获取name的属性值
            String name = properties.getProperty("name");
            System.out.println("name is "+ name);
            resource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }


}
