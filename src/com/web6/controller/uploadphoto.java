package com.web6.controller;


import com.web6.entity.User;
import com.web6.service.UploadimgService;
import com.web6.service.impl.UploadimgServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/uploadphoto")
public class uploadphoto extends HttpServlet {
     UploadimgService uploadimgService=new UploadimgServiceImpl();
     public UploadimgService uploadimgService_q=new UploadimgServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tname = req.getParameter("tname");;
       tname=new String(tname.getBytes("ISO8859_1"), "UTF-8");
        System.out.println("tname1="+tname);
        if(!ServletFileUpload.isMultipartContent(req)){
            throw new RuntimeException("当前请求不支持文件上传");
        }
        try {
            //创建一个FileItem工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传核心组件
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            //解析请求，获取到所有的item
            List<FileItem> items = servletFileUpload.parseRequest(req);
            //遍历items
            for(FileItem item : items){
                if(item.isFormField()){  //若item为普通表单项
                    String fieldName = item.getFieldName();  //获取表单项名称
                    String fieldValue = item.getString();  //获取表单项的值
                    System.out.println(fieldName + "4= " + fieldValue);
                }else{  //若item为文件表单项
                    //获取上传文件原始名称
                    String fileName = item.getName();
                    int index=fileName.lastIndexOf(".");
                    String lastname=fileName.substring(index);
                    fileName=tname+lastname;
                    System.out.println(fileName);
                    //获取输入流，其中有上传 文件的内容
                    InputStream is = item.getInputStream();
                    //获取文件保存在服务器的路径
                    String path = this.getServletContext().getRealPath("/upload");
                    //创建目标文件，将用来保存上传文件
                    File file = new File(path, fileName);
                    //将输入流中的数据写入到输出流中
                    OutputStream os = new FileOutputStream(file);
                    //将输入流中的数据写入输出流中
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while((len = is.read(buf)) != -1){
                        os.write(buf, 0, len);
                    }
                    os.close();
                    is.close();
                    User user_u=uploadimgService_q.Uploadimg(0,tname,"0",0,"email",fileName);
                    String url="index.jsp";
                    resp.sendRedirect(url);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


}
