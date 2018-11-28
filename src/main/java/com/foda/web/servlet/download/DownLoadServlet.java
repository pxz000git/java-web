package com.foda.web.servlet.download;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author pxz
 * @date 2018/11/26 0026-下午 1:33
 */
public class DownLoadServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取想要下载的文件的名字
        String fileName = req.getParameter("filename");

        //获取这个文件在tomcat里面绝对路径地址
        //String path = null;
        //    URL resource = this.getClass().getClassLoader().getResource("/");
        //    if(resource != null){
        //        path = resource.getPath();
        //    }

        // /D:/IdeaWorkspace/java-learn/my-web/target/my-web-1.0-SNAPSHOT/WEB-INF/classes/

        String path = getServletContext().getRealPath("download/" + fileName);

        //让浏览器收到这份资源的时候， 以下载的方式提醒用户，而不是直接展示。
        //resp.setHeader("Content-Disposition", "attachment; filename="+fileName);


        //转化成输入流
        FileInputStream inputStream = new FileInputStream(path);
        OutputStream outputStream = resp.getOutputStream();

        int len;
        byte[] buffer = new byte[1024];
        while( (len = inputStream.read(buffer)) != -1){
            System.out.println(new String (buffer,0,len));
            outputStream.write(buffer, 0, len);
        }

        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
