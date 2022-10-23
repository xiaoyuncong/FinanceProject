package com.javasm.base.web.control;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 文件上传
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String fileName = "";
        StringBuffer pathFile_ = new StringBuffer();


        // 1.判断是否能完成上传（method=post、enctype=multipart/form-data）
        if (ServletFileUpload.isMultipartContent(request)) {
            // 2.实例化 DiskFileItemFactory 对象，实例化 ServletFileUpload 对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            try {
                // 3.获取客户端提交到服务端的数据（二进制文件、表单元素的值）
//            String file = request.getParameter("file");
//            System.out.println(file);
                List<FileItem> fileItemList = servletFileUpload.parseRequest(request);//表单中所有的表单元素
                for (FileItem fileItem : fileItemList) {
//                    System.out.println("==================================================");
//                    System.out.println("文件名：" + fileItem.getName());
//                    System.out.println("表单元素的name属性：" + fileItem.getFieldName());
//                    System.out.println("长度：" + fileItem.getSize());
//                    System.out.println("内容：" + fileItem.getString());

                    // 4.上传
                    // 实例化 file 对象，空文件 --》要和 上传的文件后缀相同
                    if (!fileItem.isFormField()) {// fileItem.isFormField()：判断是否是一个普通的表单元素
                        // 获取项目存储的目录
                        pathFile_.append(getServletContext().getRealPath("/")).append("/img/");

                        File pathFile = new File(pathFile_.toString());
                        if (!pathFile.exists()) {// 判断存储的目录是否存在
                            pathFile.mkdir();//  创建目录
                        }

                        // 避免文件覆盖
                        fileName = new Date().getTime() + fileItem.getName();
                        // 创建空文件对象
                        File file = new File(pathFile_.append(fileName).toString());
                        // 上传
                        fileItem.write(file);

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.getWriter().write("img/" + fileName);
            }


        }


    }
}
