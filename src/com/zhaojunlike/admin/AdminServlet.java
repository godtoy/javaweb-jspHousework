package com.zhaojunlike.admin;

import com.sun.deploy.util.SessionState;
import com.sun.org.apache.xpath.internal.functions.Function;
import com.zhaojunlike.utils.Functions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhaojun on 2016/4/28.
 */
@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {


    /**
     * 全局设置
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */        /*这里需要我们进行二进制数据转码，url过来的参数是url编码过后的*/
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("AdminServlet  service method out-->");
        //设置post数据获取的编码  1.对post获取的数据编码有效
        request.setCharacterEncoding("UTF-8");
        //2.如果是GET请求，网站页面的<meta charset='GBK'>，那get的参数是gbk的编码
        //响应头的contentType
        response.setContentType("text/html");
        //响应的编码格式
        response.setCharacterEncoding("UTF-8");
        //如果不是管理员登陆就跳转到登陆界面
        if (Functions.isAdminLogin(request) == false) {
            System.out.println("请用户先登入系统");
            response.sendRedirect("/admin/public?act=login");
            return;
        }
        super.service(request, response);
    }


}
