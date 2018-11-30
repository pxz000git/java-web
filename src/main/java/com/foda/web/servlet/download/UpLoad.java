package com.foda.web.servlet.download;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

/**
 * @ author pxz
 * @ date 2018/11/29 0029-下午 6:41
 */
public class UpLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        //判断前端的for是否有multipart属性
        if(multipartContent){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);

            try {
                //通过parseRequest解析form中的所有请求字段，并保存到items集合中(即前端传递的no,name,picture)
                List<FileItem> items = fileUpload.parseRequest(req);

                //通过迭代器遍历
                Iterator<FileItem> iterator = items.iterator();
                while(iterator.hasNext()){
                    FileItem item = iterator.next();
                    //根据名字判断
                    //这里不能用request.getParameter取值，因为图片编码
                    //判断前端字段是普通form表单字段，还是文件字段
                    int no ;
                    String name;
                    if(item.isFormField()){
                        //普通字段
                        if(item.getFieldName().equals("no")){
                            no = Integer.valueOf(item.getString("UTF-8"));
                            System.out.println(String.format("no is %s",no));
                        }else if(item.getFieldName().equals("name")){
                            name = item.getString("UTF-8");
                            System.out.println(String.format("name is %s",name));

                        }else{
                            System.out.println("其他字段");
                        }
                    }else{
                        //文件字段
                        //文件上传
                        //文件名:getName()获取文件名，isFormField()获取普通表单字段
                        String fileName = item.getName();
                        //获取文件内容并上传
                        //定义文件路径，指定上传的路径(服务器路径)
                        //获取服务器路径
                        //上传路径不要是服务器部署项目的路径（webapp/ROOT），
                        // 这样通过修改代码再次编译，服务器会把原来的class文件删除（包括上传的图片）
                        //以下是idea自己的优化，没有.class路径放在tomcat中，而是告诉tomcat这路径，让它去找这路径
                        String path = req.getSession().getServletContext().getRealPath("upload");

                        File file = new File(path, fileName);
                        File parentFile = file.getParentFile();
                        if(!parentFile.exists()){
                            parentFile.mkdirs();
                        }
                        //上传
                        item.write(file);
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req,resp);
    }
}
