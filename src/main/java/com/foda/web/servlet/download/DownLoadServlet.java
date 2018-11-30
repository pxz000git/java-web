package com.foda.web.servlet.download;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author pxz
 * @date 2018/11/26 0026-下午 1:33
 */
public class DownLoadServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        //获取想要下载的文件的名字
        String fileName = req.getParameter("filename");

        //获取这个文件在tomcat里面绝对路径地址
        //String path = null;
        //    URL resource = this.getClass().getClassLoader().getResource("/");
        //    if(resource != null){
        //        path = resource.getPath();
        //    }

        //路径修改
        String path = getServletContext().getRealPath("download/" + fileName);
        File parentFile = new File(path).getParentFile().getParentFile().getParentFile();
        String parent = parentFile.getParent();
        String downPath = parent+"/src/main/webapp/download/";

        //下载文件，设置消息头
        //让浏览器收到这份资源的时候， 以下载的方式提醒用户，而不是直接展示。
        //MIME类型：application/octet-stream，表示是以二进制形式下载
        resp.addHeader("content-Type","application/octet-stream");
        resp.addHeader("Content-Disposition", "attachment; filename="+fileName);

        //转化成输入流
        //从指定的文件目录下查找
        FileInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //从D:/IdeaWorkspace/java-learn/my-web/target/my-web-1.0-SNAPSHOT编译好的文件的目录下查找
            //InputStream inputStream = getServletContext().getResourceAsStream(downPath + fileName);

            inputStream = new FileInputStream(downPath + fileName);
            outputStream = resp.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while( (len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
